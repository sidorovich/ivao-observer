package by.sidorovich.pavel.ivaoobserver.status;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;

import by.sidorovich.pavel.ivaoobserver.MainActivity;
import by.sidorovich.pavel.ivaoobserver.R;

public class IvaoStatusDownloader
{
    final static String STATUS_LAST_UPDATE = "status.last_update";

    MainActivity activity;
    SharedPreferences preferences;
    NetworkStatus status;

    public IvaoStatusDownloader(MainActivity activity)
    {
        this.activity = activity;
        preferences = activity.getPreferences(Context.MODE_PRIVATE);
    }

    protected void refreshNetworkStatus()
    {
        long diff = System.currentTimeMillis() - preferences.getLong(STATUS_LAST_UPDATE, 0);

        if (diff / (24 * 60 * 60 * 1000) > 1) { // once per day

            final DownloadStatusTask downloadStatusTask = new DownloadStatusTask(activity);
            downloadStatusTask.execute(activity.getResources().getString(R.string.ivao_status_url));

            activity.mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    downloadStatusTask.cancel(true);
                }
            });

            try {
                status = new NetworkStatus(downloadStatusTask.get());
                status.store(preferences);
            } catch (Exception e) {
            }

            preferences.edit().putLong(STATUS_LAST_UPDATE, System.currentTimeMillis()).apply();
        } else {
            status = new NetworkStatus(preferences);
        }
    }

    public NetworkStatus getNetworkStatus()
    {
        this.refreshNetworkStatus();
        return status;
    }
}
