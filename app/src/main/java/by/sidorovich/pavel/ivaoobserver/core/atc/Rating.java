package by.sidorovich.pavel.ivaoobserver.core.atc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import by.sidorovich.pavel.ivaoobserver.R;

public class Rating
{
    final public static int OBS = 1;
    final public static int AS1 = 2;
    final public static int AS2 = 3;
    final public static int AS3 = 4;
    final public static int ADC = 5;
    final public static int APC = 6;
    final public static int ACC = 7;
    final public static int SEC = 8;
    final public static int SAI = 9;
    final public static int CAI = 10;


    final private static Map<Integer, Integer> ATC_RATING_MAP;

    static {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(OBS, R.string.atc_rating_obs);
        map.put(AS1, R.string.atc_rating_as1);
        map.put(AS2, R.string.atc_rating_as2);
        map.put(AS3, R.string.atc_rating_as3);
        map.put(ADC, R.string.atc_rating_adc);
        map.put(APC, R.string.atc_rating_apc);
        map.put(ACC, R.string.atc_rating_acc);
        map.put(SEC, R.string.atc_rating_sec);
        map.put(SAI, R.string.atc_rating_sai);
        map.put(CAI, R.string.atc_rating_cai);
        ATC_RATING_MAP = Collections.unmodifiableMap(map);
    }

    public static int getStringId(int rating)
    {
        return ATC_RATING_MAP.get(rating);
    }
}
