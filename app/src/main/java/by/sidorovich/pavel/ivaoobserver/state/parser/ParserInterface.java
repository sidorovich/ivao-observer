package by.sidorovich.pavel.ivaoobserver.state.parser;

import by.sidorovich.pavel.ivaoobserver.state.ResultContainer;

public interface ParserInterface
{
    ResultContainer parseString(String string, ResultContainer result);
}
