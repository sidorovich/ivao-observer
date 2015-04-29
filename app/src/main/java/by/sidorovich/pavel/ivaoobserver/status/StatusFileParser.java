package by.sidorovich.pavel.ivaoobserver.status;

import android.content.ContentValues;
import android.util.Log;

public class StatusFileParser
{
    final char COMMENT_SIGN = ';';
    final String DELIMITER = "=";

    String string;

    public ContentValues parseString(String string, ContentValues result)
    {
        this.string = string;

        if (!isComment() && isParsable()) {
            String[] split = string.split(DELIMITER);
            result.put(split[0], split[1]);
        }

        return result;
    }

    private Boolean isComment()
    {
        return COMMENT_SIGN == string.charAt(0);
    }

    private Boolean isParsable()
    {
        return string.contains(DELIMITER);
    }
}
