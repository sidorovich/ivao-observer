package by.sidorovich.pavel.ivaoobserver;

import android.content.Context;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

abstract public class AbstractDownloadTask<Params, Result> extends AsyncTask<Params, Integer, Result>
{
    private MainActivity activity;
    private PowerManager.WakeLock mWakeLock;
    protected Result result;

    abstract protected Result processString(String string, Result result);
    abstract protected Result initializeResult();

    public AbstractDownloadTask(MainActivity activity)
    {
        this.activity = activity;
    }

    protected Result doInBackground(String... sUrl)
    {
        HttpURLConnection connection = null;
        result = initializeResult();

        try {
            URL url = new URL(sUrl[0]);

            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return null;
            }

            int fileLength = connection.getContentLength();

            long total = 0;
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;

            while ((str = in.readLine()) != null) {
                if (isCancelled()) {
                    in.close();
                    return null;
                }

                result = processString(str, result);

                total += str.length();
                if (fileLength > 0) {
                    publishProgress((int) (total * 100 / fileLength));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return result;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // take CPU lock to prevent CPU from going off if the user
        // presses the power button during download
        PowerManager pm = (PowerManager) activity.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, getClass().getName());
        mWakeLock.acquire();

        activity.mProgressDialog.show();
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
        // if we get here, length is known, now set indeterminate to false
        activity.mProgressDialog.setIndeterminate(false);
        activity.mProgressDialog.setMax(100);
        activity.mProgressDialog.setProgress(progress[0]);
    }

    @Override
    protected void onPostExecute(Result result) {
        mWakeLock.release();
        activity.mProgressDialog.dismiss();
        if (result == null) {
            Toast.makeText(activity, "Download error", Toast.LENGTH_LONG).show();
        }
    }
}
