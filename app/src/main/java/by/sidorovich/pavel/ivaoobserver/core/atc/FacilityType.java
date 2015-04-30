package by.sidorovich.pavel.ivaoobserver.core.atc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import by.sidorovich.pavel.ivaoobserver.R;

final public class FacilityType
{
    final public static int OBSERVER = 0;
    final public static int FIS = 1;
    final public static int DELIVERY = 2;
    final public static int GROUND = 3;
    final public static int TOWER = 4;
    final public static int APPROACH = 5;
    final public static int ACC = 6;
    final public static int DEPARTURE = 7;

    final private static Map<Integer, Integer> FACILITY_TYPE_MAP;

    static {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(OBSERVER, R.string.facility_type_observer);
        map.put(FIS, R.string.facility_type_fis);
        map.put(DELIVERY, R.string.facility_type_delivery);
        map.put(GROUND, R.string.facility_type_ground);
        map.put(TOWER, R.string.facility_type_tower);
        map.put(APPROACH, R.string.facility_type_approach);
        map.put(ACC, R.string.facility_type_acc);
        map.put(DEPARTURE, R.string.facility_type_departure);
        FACILITY_TYPE_MAP = Collections.unmodifiableMap(map);
    }

    public static int getStringId(int facilityType)
    {
        return FACILITY_TYPE_MAP.get(facilityType);
    }
}
