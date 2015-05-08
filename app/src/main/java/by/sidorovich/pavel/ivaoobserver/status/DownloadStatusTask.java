package by.sidorovich.pavel.ivaoobserver.status;

import android.content.ContentValues;

import by.sidorovich.pavel.ivaoobserver.AbstractDownloadTask;
import by.sidorovich.pavel.ivaoobserver.MainActivity;

public class DownloadStatusTask extends AbstractDownloadTask<String, ContentValues>
{
    StatusFileParser fileParser;

    @Override
    protected ContentValues processString(String string, ContentValues contentValues)
    {
        return fileParser.parseString(string, contentValues);
    }

    @Override
    protected ContentValues initializeResult()
    {
        return new ContentValues();
    }

    public DownloadStatusTask(MainActivity activity)
    {
        super(activity);
        fileParser = new StatusFileParser();
    }
}
