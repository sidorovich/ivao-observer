package by.sidorovich.pavel.ivaoobserver.status;

import android.content.ContentValues;
import android.content.SharedPreferences;

public class NetworkStatus
{
    final String MESSAGE = "msg0";
    final String WHAZZUP = "url0";
    final String PREFIX = "status.content_values.";

    final String[] keys = {
            MESSAGE,
            WHAZZUP,
    };

    protected ContentValues storage;

    public NetworkStatus(ContentValues values)
    {
        this.storage = values;
    }

    public NetworkStatus(SharedPreferences preferences)
    {
        storage = new ContentValues();
        for (String key : keys) {
            storage.put(key, preferences.getString(PREFIX + key, ""));
        }
    }

    public String getMessage()
    {
        String message = storage.getAsString(MESSAGE);
        return (message != null) ? message : "";
    }

    public String getWhazzupUrl()
    {
        String url = storage.getAsString(WHAZZUP);
        return (url != null) ? url : "";
    }

    public void store(SharedPreferences preferences)
    {
        SharedPreferences.Editor editor = preferences.edit();
        for (String key : keys) {
            editor.putString(PREFIX + key, storage.getAsString(key));
        }
        editor.apply();
    }
}
