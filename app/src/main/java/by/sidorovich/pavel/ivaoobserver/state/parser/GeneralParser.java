package by.sidorovich.pavel.ivaoobserver.state.parser;

import by.sidorovich.pavel.ivaoobserver.state.ResultContainer;

public class GeneralParser implements ParserInterface
{
    protected final String NAME_VERSION = "VERSION";
    protected final String NAME_RELOAD = "RELOAD";
    protected final String NAME_UPDATE = "UPDATE";
    protected final String NAME_CLIENTS = "CONNECTED CLIENTS";
    protected final String NAME_SERVERS = "CONNECTED SERVERS";
    protected final String NAME_AIRPORTS = "CONNECTED AIRPORTS";

    @Override
    public ResultContainer parseString(String string, ResultContainer result)
    {
        String[] split = string.split("=");

        switch (split[0].trim()) {
            case NAME_VERSION:
                result.generalInfo().setProtocolVersion(Integer.valueOf(split[1].trim()));
                break;

            case NAME_RELOAD:
                result.generalInfo().setReloadInterval(Integer.valueOf(split[1].trim()));
                break;

            case NAME_UPDATE:
                result.generalInfo().setTimestamp(split[1].trim());
                break;

            case NAME_CLIENTS:
                result.generalInfo().setClientsCount(Integer.valueOf(split[1].trim()));
                break;

            case NAME_SERVERS:
                result.generalInfo().setServersCount(Integer.valueOf(split[1].trim()));
                break;

            case NAME_AIRPORTS:
                result.generalInfo().setAirportsCount(Integer.valueOf(split[1].trim()));
                break;
        }

        return result;
    }
}
