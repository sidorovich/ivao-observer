package by.sidorovich.pavel.ivaoobserver.core.pilot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import by.sidorovich.pavel.ivaoobserver.R;

public class Simulator
{
    final public static int UNKNOWN = 0;
    final public static int MSFS95 = 1;
    final public static int MSFS98 = 2;
    final public static int MSCFS = 3;
    final public static int MSFS2K = 4;
    final public static int MSCFS2 = 5;
    final public static int MSFS2002 = 6;
    final public static int MSCFS3 = 7;
    final public static int MSFS9 = 8;
    final public static int MSFSX = 9;
    final public static int XP = 11;
    final public static int XP8 = 12;
    final public static int XP9 = 13;
    final public static int XP10 = 14;
    final public static int PS1 = 15;
    final public static int XP11 = 16;
    final public static int XP12 = 17;
    final public static int FLY = 20;
    final public static int FLY2 = 21;
    final public static int FG = 25;
    final public static int PREPAR = 30;

    final private static Map<Integer, Integer> SIMULATOR_MAP;

    static {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(UNKNOWN, R.string.simulator_unknown);
        map.put(MSFS95, R.string.simulator_msfs95);
        map.put(MSFS98, R.string.simulator_msfs98);
        map.put(MSCFS, R.string.simulator_mscfs);
        map.put(MSFS2K, R.string.simulator_msfs2k);
        map.put(MSCFS2, R.string.simulator_mscfs2);
        map.put(MSFS2002, R.string.simulator_msfs2002);
        map.put(MSCFS3, R.string.simulator_mscfs3);
        map.put(MSFS9, R.string.simulator_msfs9);
        map.put(MSFSX, R.string.simulator_msfsx);
        map.put(XP, R.string.simulator_xp);
        map.put(XP8, R.string.simulator_xp8);
        map.put(XP9, R.string.simulator_xp9);
        map.put(XP10, R.string.simulator_xp10);
        map.put(PS1, R.string.simulator_ps1);
        map.put(XP11, R.string.simulator_xp11);
        map.put(XP12, R.string.simulator_xp12);
        map.put(FLY, R.string.simulator_fly);
        map.put(FLY2, R.string.simulator_fly2);
        map.put(FG, R.string.simulator_fg);
        map.put(PREPAR, R.string.simulator_prepar);
        SIMULATOR_MAP = Collections.unmodifiableMap(map);
    }

    public static int getStringId(int rating)
    {
        return SIMULATOR_MAP.get(rating);
    }
}
