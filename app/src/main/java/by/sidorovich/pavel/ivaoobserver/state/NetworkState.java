package by.sidorovich.pavel.ivaoobserver.state;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;

import by.sidorovich.pavel.ivaoobserver.MainActivity;

public class NetworkState
{
    final static String STATE_LAST_UPDATE = "state.last_update";
    final static String STATE_NEXT_UPDATE = "state.next_update";

    MainActivity activity;
    String url;
    SharedPreferences preferences;
    ResultContainer result;

    public NetworkState(MainActivity activity, String url)
    {
        this.activity = activity;
        this.url = url;
        preferences = activity.getPreferences(Context.MODE_PRIVATE);
    }

    public void refresh()
    {
        if (isCanDownload()) {
            final DownloadStateTask downloadStateTaskTask = new DownloadStateTask(activity);
            downloadStateTaskTask.execute(url);

            activity.mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
            {
                @Override
                public void onCancel(DialogInterface dialog)
                {
                    downloadStateTaskTask.cancel(true);
                }
            });

            try {
                result = downloadStateTaskTask.get();

                if (result != null) {
                    Log.d("mylogs", "Pilots: " + String.valueOf(result.pilots().size()));
                    Log.d("mylogs", "ATCs: " + String.valueOf(result.atc().size()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            preferences.edit()
                    .putLong(STATE_LAST_UPDATE, System.currentTimeMillis())
                    .putLong(STATE_NEXT_UPDATE, System.currentTimeMillis() + 120000)
                    .apply();
        }
    }

    protected Boolean isCanDownload()
    {
        return System.currentTimeMillis() >= preferences.getLong(STATE_NEXT_UPDATE, System.currentTimeMillis());
    }
}
