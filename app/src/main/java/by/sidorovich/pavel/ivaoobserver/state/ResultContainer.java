package by.sidorovich.pavel.ivaoobserver.state;

import java.util.ArrayList;
import java.util.List;

import by.sidorovich.pavel.ivaoobserver.core.Atc;
import by.sidorovich.pavel.ivaoobserver.core.Pilot;

public class ResultContainer
{
    protected GeneralInfo generalInfo;

    protected List<Atc> atc;

    protected List<Pilot> pilots;

    public ResultContainer()
    {
        generalInfo = new GeneralInfo();
        atc = new ArrayList<Atc>();
        pilots = new ArrayList<Pilot>();
    }

    public GeneralInfo generalInfo()
    {
        return generalInfo;
    }

    public void appendPilot(Pilot pilot)
    {
        pilots.add(pilot);
    }

    public void appendAtc(Atc atc)
    {
        this.atc.add(atc);
    }

    public List<Atc> atc()
    {
        return atc;
    }

    public List<Pilot> pilots()
    {
        return pilots;
    }
}
