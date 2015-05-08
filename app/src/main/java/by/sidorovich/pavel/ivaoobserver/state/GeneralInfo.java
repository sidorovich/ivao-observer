package by.sidorovich.pavel.ivaoobserver.state;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class GeneralInfo
{
    protected int protocolVersion;

    protected int reloadInterval; // minutes

    protected Date timestamp;

    protected int clientsCount;

    protected int serversCount;

    protected int airportsCount;

    public void setProtocolVersion(int protocolVersion)
    {
        this.protocolVersion = protocolVersion;
    }

    public int protocolVersion()
    {
        return protocolVersion;
    }

    public void setReloadInterval(int reloadInterval)
    {
        this.reloadInterval = reloadInterval;
    }

    public void setTimestamp(String timestamp)
    {
        try {
            DateFormat inputFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            this.timestamp = inputFormat.parse(timestamp);
        } catch (Exception e) {
            this.timestamp = new Date();
        }
    }

    public long nextUpdateTime()
    {
        return timestamp.getTime() + reloadInterval * 60000;
    }

    public void setClientsCount(int clientsCount)
    {
        this.clientsCount = clientsCount;
    }

    public int clientsCount()
    {
        return clientsCount;
    }

    public void setServersCount(int serversCount)
    {
        this.serversCount = serversCount;
    }

    public void setAirportsCount(int airportsCount)
    {
        this.airportsCount = airportsCount;
    }
}
