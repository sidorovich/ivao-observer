package by.sidorovich.pavel.ivaoobserver;

import android.content.SharedPreferences;
import android.util.Log;

public class IvaoStatusDownloader
{
    final static String STATUS_MESSAGE = "status.message";
    final static String STATUS_LAST_UPDATE = "status.last_update";

    SharedPreferences preferences;

    public IvaoStatusDownloader(SharedPreferences preferences)
    {
        this.preferences = preferences;
    }

    public void refreshNetworkStatus()
    {
        long diff = System.currentTimeMillis() - this.lastStatusUpdateMillis();
        if (diff / (24 * 60 * 60 * 1000) > 1) {


            preferences.edit().putLong(STATUS_LAST_UPDATE, System.currentTimeMillis()).apply();
        }
    }

    protected long lastStatusUpdateMillis()
    {
        return preferences.getLong(STATUS_LAST_UPDATE, 0);
    }
}
