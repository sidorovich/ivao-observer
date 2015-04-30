package by.sidorovich.pavel.ivaoobserver.core.pilot;

import java.util.Date;

public class FlightPlan
{
    protected String aircraft;
    protected String cruisingSpeed;
    protected String departureAirport;
    protected String cruisingLevel;
    protected String destinationAirport;
    protected int revision;
    protected String flightRules;
    protected Date departureTime;
    protected Date actualDepartureTime;
    protected int eetHours;
    protected int eetMinutes;
    protected int enduranceHours;
    protected int enduranceMinutes;
    protected String alternateAirport;
    protected String remarks;
    protected String route;
    protected String secondAlternateAirport;
    protected String typeOfFlight;
    protected int personsOnBoard;

    public FlightPlan setAircraft(String aircraft)
    {
        this.aircraft = aircraft;
        return this;
    }

    public String aircraft()
    {
        return aircraft;
    }

    public FlightPlan setCruisingSpeed(String cruisingSpeed)
    {
        this.cruisingSpeed = cruisingSpeed;
        return this;
    }

    public String cruisingSpeed()
    {
        return cruisingSpeed;
    }

    public FlightPlan setDepartureAirport(String departureAirport)
    {
        this.departureAirport = departureAirport;
        return this;
    }

    public String departureAirport()
    {
        return departureAirport;
    }

    public FlightPlan setCruisingLevel(String cruisingLevel)
    {
        this.cruisingLevel = cruisingLevel;
        return this;
    }

    public String cruisingLevel()
    {
        return cruisingLevel;
    }

    public FlightPlan setDestinationAirport(String destinationAirport)
    {
        this.destinationAirport = destinationAirport;
        return this;
    }

    public String destinationAirport()
    {
        return destinationAirport;
    }

    public FlightPlan setRevision(int revision)
    {
        this.revision = revision;
        return this;
    }

    public int revision()
    {
        return revision;
    }

    public FlightPlan setFlightRules(String flightRules)
    {
        this.flightRules = flightRules;
        return this;
    }

    public String flightRules()
    {
        return flightRules;
    }

    public FlightPlan setDepartureTime(Date departureTime)
    {
        this.departureTime = departureTime;
        return this;
    }

    public Date departureTime()
    {
        return departureTime;
    }

    public FlightPlan setActualDepartureTime(Date actualDepartureTime)
    {
        this.actualDepartureTime = actualDepartureTime;
        return this;
    }

    public Date actualDepartureTime()
    {
        return actualDepartureTime;
    }

    public FlightPlan setEetHours(int eetHours)
    {
        this.eetHours = eetHours;
        return this;
    }

    public int eetHours()
    {
        return eetHours;
    }

    public FlightPlan setEetMinutes(int eetMinutes)
    {
        this.eetMinutes = eetMinutes;
        return this;
    }

    public int eetMinutes()
    {
        return eetMinutes;
    }

    public FlightPlan setEnduranceHours(int enduranceHours)
    {
        this.enduranceHours = enduranceHours;
        return this;
    }

    public int enduranceHours()
    {
        return enduranceHours;
    }

    public FlightPlan setEnduranceMinutes(int enduranceMinutes)
    {
        this.enduranceMinutes = enduranceMinutes;
        return this;
    }

    public int enduranceMinutes()
    {
        return enduranceMinutes;
    }

    public FlightPlan setAlternateAirport(String alternateAirport)
    {
        this.alternateAirport = alternateAirport;
        return this;
    }

    public String alternateAirport()
    {
        return alternateAirport;
    }

    public FlightPlan setRemarks(String remarks)
    {
        this.remarks = remarks;
        return this;
    }

    public String remarks()
    {
        return remarks;
    }

    public FlightPlan setRoute(String route)
    {
        this.route = route;
        return this;
    }

    public String route()
    {
        return route;
    }

    public FlightPlan setSecondAlternateAirport(String secondAlternateAirport)
    {
        this.secondAlternateAirport = secondAlternateAirport;
        return this;
    }

    public String secondAlternateAirport()
    {
        return secondAlternateAirport;
    }

    public FlightPlan setTypeOfFlight(String typeOfFlight)
    {
        this.typeOfFlight = typeOfFlight;
        return this;
    }

    public String typeOfFlight()
    {
        return typeOfFlight;
    }

    public FlightPlan setPersonsOnBoard(int personsOnBoard)
    {
        this.personsOnBoard = personsOnBoard;
        return this;
    }

    public int personsOnBoard()
    {
        return personsOnBoard;
    }
}
