package by.sidorovich.pavel.ivaoobserver.core.pilot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import by.sidorovich.pavel.ivaoobserver.R;

public class Rating
{
    final public static int OBS = 1;
    final public static int FS1 = 2;
    final public static int FS2 = 3;
    final public static int FS3 = 4;
    final public static int PP = 5;
    final public static int SPP = 6;
    final public static int CP = 7;
    final public static int ATP = 8;
    final public static int SFI = 9;
    final public static int CFI = 10;

    final private static Map<Integer, Integer> PILOT_RATING_MAP;

    static {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(OBS, R.string.pilot_rating_obs);
        map.put(FS1, R.string.pilot_rating_fs1);
        map.put(FS2, R.string.pilot_rating_fs2);
        map.put(FS3, R.string.pilot_rating_fs3);
        map.put(PP, R.string.pilot_rating_pp);
        map.put(SPP, R.string.pilot_rating_spp);
        map.put(CP, R.string.pilot_rating_cp);
        map.put(ATP, R.string.pilot_rating_atp);
        map.put(SFI, R.string.pilot_rating_sfi);
        map.put(CFI, R.string.pilot_rating_cfi);
        PILOT_RATING_MAP = Collections.unmodifiableMap(map);
    }

    public static int getStringId(int rating)
    {
        return PILOT_RATING_MAP.get(rating);
    }
}
