package by.sidorovich.pavel.ivaoobserver.state.parser;

import java.security.InvalidParameterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import by.sidorovich.pavel.ivaoobserver.core.Atc;
import by.sidorovich.pavel.ivaoobserver.core.NetworkClient;
import by.sidorovich.pavel.ivaoobserver.core.Pilot;
import by.sidorovich.pavel.ivaoobserver.core.pilot.FlightPlan;
import by.sidorovich.pavel.ivaoobserver.state.ResultContainer;

final public class ClientsParser implements ParserInterface
{
    final private static String DELIMITER = ":";

    final private static int DATA_INDEX_CALL_SIGN = 0;
    final private static int DATA_INDEX_VID = 1;
    final private static int DATA_INDEX_NAME = 2;
    final private static int DATA_INDEX_CLIENT_TYPE = 3;
    final private static int DATA_INDEX_FREQUENCY = 4;
    final private static int DATA_INDEX_LATITUDE = 5;
    final private static int DATA_INDEX_LONGITUDE = 6;
    final private static int DATA_INDEX_ALTITUDE = 7;
    final private static int DATA_INDEX_GROUND_SPEED = 8;
    final private static int DATA_INDEX_FPL_AIRCRAFT = 9;
    final private static int DATA_INDEX_FPL_CRUISING_SPEED = 10;
    final private static int DATA_INDEX_FPL_DEPARTURE_AIRPORT = 11;
    final private static int DATA_INDEX_FPL_CRUISING_LEVEL = 12;
    final private static int DATA_INDEX_FPL_DESTINATION_AIRPORT = 13;
    final private static int DATA_INDEX_SERVER = 14;
    final private static int DATA_INDEX_PROTOCOL = 15;
    final private static int DATA_INDEX_COMBINED_RATING = 16;
    final private static int DATA_INDEX_TRANSPONDER = 17;
    final private static int DATA_INDEX_FACILITY_TYPE = 18;
    final private static int DATA_INDEX_VISUAL_RANGE = 19;
    final private static int DATA_INDEX_FPL_REVISION = 20;
    final private static int DATA_INDEX_FPL_FLIGHT_RULES = 21;
    final private static int DATA_INDEX_FPL_DEPARTURE_TIME = 22;
    final private static int DATA_INDEX_FPL_ACTUAL_DEPARTURE_TIME = 23;
    final private static int DATA_INDEX_FPL_EET_HOURS = 24;
    final private static int DATA_INDEX_FPL_EET_MINUTES = 25;
    final private static int DATA_INDEX_FPL_ENDURANCE_HOURS = 26;
    final private static int DATA_INDEX_FPL_ENDURANCE_MINUTES = 27;
    final private static int DATA_INDEX_FPL_ALTERNATE_AIRPORT = 28;
    final private static int DATA_INDEX_FPL_REMARKS = 29;
    final private static int DATA_INDEX_FPL_ROUTE = 30;
    final private static int DATA_INDEX_UNUSED_1 = 31;
    final private static int DATA_INDEX_UNUSED_2 = 32;

    final private static int DATA_INDEX_ATIS = 35;
    final private static int DATA_INDEX_ATIS_TIME = 36;
    final private static int DATA_INDEX_CONNECTION_TIME = 37;
    final private static int DATA_INDEX_SOFTWARE_NAME = 38;
    final private static int DATA_INDEX_SOFTWARE_VERSION = 39;
    final private static int DATA_INDEX_ADMINISTRATIVE_RATING = 40;
    final private static int DATA_INDEX_ATC_PILOT_RATING = 41;
    final private static int DATA_INDEX_FPL_ALTERNATE_AIRPORT_2 = 42;
    final private static int DATA_INDEX_FPL_TYPE_OF_FLIGHT = 43;
    final private static int DATA_INDEX_FPL_PERSONS_ON_BOARD = 44;
    final private static int DATA_INDEX_HEADING = 45;
    final private static int DATA_INDEX_ON_GROUND = 46;
    final private static int DATA_INDEX_SIMULATOR = 47;
    final private static int DATA_INDEX_MTL_PLANE = 48;

    @Override
    public ResultContainer parseString(String string, ResultContainer result)
    {
        String[] split = string.split(DELIMITER);

        try {
            switch (split[DATA_INDEX_CLIENT_TYPE]) {
                case NetworkClient.TYPE_PILOT:
                    result.appendPilot(parseAsPilot(split));
                    break;

                case NetworkClient.TYPE_ATC:
                    result.appendAtc(parseAsAtc(split));
                    break;

                case NetworkClient.TYPE_FOLLOW_ME:
                    // @todo: add follow me
                    break;

                default:
                    throw new InvalidParameterException("Unknown or empty client type " + split[3]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    protected static NetworkClient parseGeneralData(NetworkClient client, String[] data)
    {
        return client
                .setCallSign(data[DATA_INDEX_CALL_SIGN])
                .setVid(data[DATA_INDEX_VID])
                .setName(data[DATA_INDEX_NAME])
                .setClientType(data[DATA_INDEX_CLIENT_TYPE])

                .setLatitude(parseFloat(data[DATA_INDEX_LATITUDE]))
                .setLongitude(parseFloat(data[DATA_INDEX_LONGITUDE]))
                .setAltitude(parseFloat(data[DATA_INDEX_ALTITUDE]))

                .setServer(data[DATA_INDEX_SERVER])
                .setProtocol(data[DATA_INDEX_PROTOCOL])

                .setConnectionTime(parseDateTime(data[DATA_INDEX_CONNECTION_TIME]))
                .setSoftwareName(data[DATA_INDEX_SOFTWARE_NAME])
                .setSoftwareVersion(data[DATA_INDEX_SOFTWARE_VERSION])
                .setAdministrativeRating(parseInt(data[DATA_INDEX_ADMINISTRATIVE_RATING]))
        ;
    }

    protected static Pilot parseAsPilot(String[] data)
    {
        return ((Pilot) parseGeneralData(new Pilot(), data))
                .setFlightPlan(parseFlightPlan(data))
                .setGroundSpeed(parseFloat(data[DATA_INDEX_GROUND_SPEED]))
                .setPilotRating(parseInt(data[DATA_INDEX_ATC_PILOT_RATING]))
                .setTransponder(data[DATA_INDEX_TRANSPONDER])
                .setHeading(parseInt(data[DATA_INDEX_HEADING]))
                .setOnGround(data[DATA_INDEX_ON_GROUND].equals("1"))
                .setSimulator(parseInt(data[DATA_INDEX_SIMULATOR]))
                .setMtlPlane(data[DATA_INDEX_MTL_PLANE])
        ;
    }

    protected static FlightPlan parseFlightPlan(String[] data)
    {
        return (new FlightPlan())
                .setAircraft(data[DATA_INDEX_FPL_AIRCRAFT])
                .setCruisingSpeed(data[DATA_INDEX_FPL_CRUISING_SPEED])
                .setDepartureAirport(data[DATA_INDEX_FPL_DEPARTURE_AIRPORT])
                .setCruisingLevel(data[DATA_INDEX_FPL_CRUISING_LEVEL])
                .setDestinationAirport(data[DATA_INDEX_FPL_DESTINATION_AIRPORT])

                .setRevision(parseInt(data[DATA_INDEX_FPL_REVISION]))
                .setFlightRules(data[DATA_INDEX_FPL_FLIGHT_RULES])
                .setDepartureTime(parseTime(data[DATA_INDEX_FPL_DEPARTURE_TIME]))
                .setActualDepartureTime(parseTime(data[DATA_INDEX_FPL_ACTUAL_DEPARTURE_TIME]))
                .setEetHours(parseInt(data[DATA_INDEX_FPL_EET_HOURS]))
                .setEetMinutes(parseInt(data[DATA_INDEX_FPL_EET_MINUTES]))
                .setEnduranceHours(parseInt(data[DATA_INDEX_FPL_ENDURANCE_HOURS]))
                .setEnduranceMinutes(parseInt(data[DATA_INDEX_FPL_ENDURANCE_MINUTES]))
                .setAlternateAirport(data[DATA_INDEX_FPL_ALTERNATE_AIRPORT])
                .setRemarks(data[DATA_INDEX_FPL_REMARKS])
                .setRoute(data[DATA_INDEX_FPL_ROUTE])

                .setSecondAlternateAirport(data[DATA_INDEX_FPL_ALTERNATE_AIRPORT_2])
                .setTypeOfFlight(data[DATA_INDEX_FPL_TYPE_OF_FLIGHT])
                .setPersonsOnBoard(parseInt(data[DATA_INDEX_FPL_PERSONS_ON_BOARD]))
        ;
    }

    protected static Atc parseAsAtc(String[] data)
    {
        return ((Atc) parseGeneralData(new Atc(), data))
                .setFrequency(data[DATA_INDEX_FREQUENCY])
                .setAtcRating(parseInt(data[DATA_INDEX_ATC_PILOT_RATING]))
                .setFacilityType(parseInt(data[DATA_INDEX_FACILITY_TYPE]))
                .setVisualRange(parseInt(data[DATA_INDEX_VISUAL_RANGE]))
                .setAtis(data[DATA_INDEX_ATIS])
                .setAtisTime(parseDateTime(data[DATA_INDEX_ATIS_TIME]))
        ;
    }

    protected static Date parseDateTime(String datetime)
    {
        return parseDateTime(datetime, "yyyyMMddHHmmss");
    }

    protected static Date parseTime(String time)
    {
        return parseDateTime(time, "HHmm");
    }

    protected static Date parseDateTime(String datetime, String format)
    {
        Date result;
        try {
            DateFormat inputFormat = new SimpleDateFormat(format);
            inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            result = inputFormat.parse(datetime);
        } catch (Exception e) {
            result = null;
        }

        return result;
    }

    protected static int parseInt(String value)
    {
        int result;
        try {
            result = Integer.parseInt(value);
        } catch (Exception e) {
            result = 0;
        }

        return result;
    }

    protected static float parseFloat(String value)
    {
        float result;
        try {
            result = Float.parseFloat(value);
        } catch (Exception e) {
            result = (float) 0.0;
        }

        return result;
    }
}
