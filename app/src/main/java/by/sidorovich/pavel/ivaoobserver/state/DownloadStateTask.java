package by.sidorovich.pavel.ivaoobserver.state;

import by.sidorovich.pavel.ivaoobserver.AbstractDownloadTask;
import by.sidorovich.pavel.ivaoobserver.MainActivity;

import by.sidorovich.pavel.ivaoobserver.state.parser.ParserInterface;
import by.sidorovich.pavel.ivaoobserver.state.parser.ClientsParser;
import by.sidorovich.pavel.ivaoobserver.state.parser.GeneralParser;

public class DownloadStateTask extends AbstractDownloadTask<String, ResultContainer>
{
    final protected String GENERAL_PARSER = "!GENERAL";
    final protected String CLIENTS_PARSER = "!CLIENTS";
    final protected String SERVERS_PARSER = "!SERVERS";
    final protected String AIRPORTS_PARSER = "!AIRPORTS";

    ParserInterface parser = null;

    public DownloadStateTask(MainActivity activity)
    {
        super(activity);
    }

    @Override
    protected ResultContainer processString(String string, ResultContainer resultContainer)
    {
        switch (string) {
            case GENERAL_PARSER:
                parser = new GeneralParser();
                break;

            case CLIENTS_PARSER:
                parser = new ClientsParser();
                break;

            case SERVERS_PARSER:
                parser = null;
                break;

            case AIRPORTS_PARSER:
                parser = null;
                break;

            default:
                if (parser != null) {
                    resultContainer = parser.parseString(string, resultContainer);
                }
                break;
        }

        return resultContainer;
    }

    @Override
    protected ResultContainer initializeResult()
    {
        return new ResultContainer();
    }
}
