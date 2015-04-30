package by.sidorovich.pavel.ivaoobserver.core.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import by.sidorovich.pavel.ivaoobserver.R;

public class AdministrativeRating
{
    final public static int SUSPENDED = 0;
    final public static int OBSERVER = 1;
    final public static int USER = 2;
    final public static int SUPERVISOR = 11;
    final public static int ADMINISTRATOR = 12;

    final private static Map<Integer, Integer> ADMINISTRATIVE_RATING_MAP;
    static {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(SUSPENDED, R.string.administrative_rating_suspended);
        map.put(OBSERVER, R.string.administrative_rating_observer);
        map.put(USER, R.string.administrative_rating_user);
        map.put(SUPERVISOR, R.string.administrative_rating_supervisor);
        map.put(ADMINISTRATOR, R.string.administrative_rating_administrator);
        ADMINISTRATIVE_RATING_MAP = Collections.unmodifiableMap(map);
    }

    public static int getStringId(int administrativeRating)
    {
        return ADMINISTRATIVE_RATING_MAP.get(administrativeRating);
    }
}
