package by.sidorovich.pavel.ivaoobserver;

import android.content.SharedPreferences;

public class IvaoStatus
{
    IvaoStatusDownloader statusDownloader;

    public IvaoStatus(SharedPreferences preferences)
    {
        statusDownloader = new IvaoStatusDownloader(preferences);
        statusDownloader.refreshNetworkStatus();
    }
}
