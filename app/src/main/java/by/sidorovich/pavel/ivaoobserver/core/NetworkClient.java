package by.sidorovich.pavel.ivaoobserver.core;

import java.util.Date;

import by.sidorovich.pavel.ivaoobserver.core.client.AdministrativeRating;

abstract public class NetworkClient
{
    final public static String TYPE_ATC = "ATC";
    final public static String TYPE_PILOT = "PILOT";
    final public static String TYPE_FOLLOW_ME = "FOLME";

    final public static int CLIENT_TYPE_ATC = 1;
    final public static int CLIENT_TYPE_PILOT = 2;
    final public static int CLIENT_TYPE_FOLLOW_ME = 3;

    protected String callSign;
    protected String vid;
    protected String name;
    protected int clientType;

    protected float latitude;
    protected float longitude;
    protected float altitude;

    protected String server;
    protected String protocol;

    protected Date connectionTime;
    protected String softwareName;
    protected String softwareVersion;
    protected int administrativeRating;

    public NetworkClient setCallSign(String callSign)
    {
        this.callSign = callSign;
        return this;
    }

    public String callSign()
    {
        return callSign;
    }

    public NetworkClient setVid(String vid)
    {
        this.vid = vid;
        return this;
    }

    public String vid()
    {
        return vid;
    }

    public NetworkClient setName(String name)
    {
        this.name = name;
        return this;
    }

    public String name()
    {
        return name;
    }

    public NetworkClient setClientType(int clientType)
    {
        this.clientType = clientType;
        return this;
    }

    public NetworkClient setClientType(String clientType)
    {
        switch (clientType) {
            case TYPE_PILOT:
                setClientType(CLIENT_TYPE_PILOT);
                break;
            case TYPE_FOLLOW_ME:
                setClientType(CLIENT_TYPE_FOLLOW_ME);
                break;
            case TYPE_ATC:
            default:
                setClientType(CLIENT_TYPE_ATC);
                break;
        }

        return this;
    }

    public int clientType()
    {
        return clientType;
    }

    public Boolean isPilot()
    {
        return clientType == CLIENT_TYPE_PILOT;
    }

    public Boolean isAtc()
    {
        return clientType == CLIENT_TYPE_ATC;
    }

    public NetworkClient setLatitude(float latitude)
    {
        this.latitude = latitude;
        return this;
    }

    public float latitude()
    {
        return latitude;
    }

    public NetworkClient setLongitude(float longitude)
    {
        this.longitude = longitude;
        return this;
    }

    public float longitude()
    {
        return longitude;
    }

    public NetworkClient setAltitude(float altitude)
    {
        this.altitude = altitude;
        return this;
    }

    public float altitude()
    {
        return altitude;
    }

    public NetworkClient setServer(String server)
    {
        this.server = server;
        return this;
    }

    public String server()
    {
        return server;
    }

    public NetworkClient setProtocol(String protocol)
    {
        this.protocol = protocol;
        return this;
    }

    public String protocol()
    {
        return protocol;
    }

    public NetworkClient setConnectionTime(Date connectionTime)
    {
        this.connectionTime = connectionTime;
        return this;
    }

    public Date connectionTime()
    {
        return connectionTime;
    }

    public NetworkClient setSoftwareName(String softwareName)
    {
        this.softwareName = softwareName;
        return this;
    }

    public String softwareName()
    {
        return softwareName;
    }

    public NetworkClient setSoftwareVersion(String softwareVersion)
    {
        this.softwareVersion = softwareVersion;
        return this;
    }

    public String softwareVersion()
    {
        return softwareVersion;
    }

    public NetworkClient setAdministrativeRating(int administrativeRating)
    {
        this.administrativeRating = administrativeRating;
        return this;
    }

    public int administrativeRating()
    {
        return administrativeRating;
    }

    public int administrativeRatingStringId()
    {
        return AdministrativeRating.getStringId(administrativeRating);
    }


}
