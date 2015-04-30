package by.sidorovich.pavel.ivaoobserver.core;

import by.sidorovich.pavel.ivaoobserver.core.pilot.FlightPlan;
import by.sidorovich.pavel.ivaoobserver.core.pilot.Rating;
import by.sidorovich.pavel.ivaoobserver.core.pilot.Simulator;

public class Pilot extends NetworkClient
{
    protected float groundSpeed;
    protected FlightPlan flightPlan;
    protected int pilotRating;
    protected String transponder;
    protected int heading;
    protected Boolean onGround;
    protected int simulator;
    protected String mtlPlane;

    public Pilot setGroundSpeed(float groundSpeed)
    {
        this.groundSpeed = groundSpeed;
        return this;
    }

    public float groundSpeed()
    {
        return groundSpeed;
    }

    public Pilot setFlightPlan(FlightPlan flightPlan)
    {
        this.flightPlan = flightPlan;
        return this;
    }

    public FlightPlan flightPlan()
    {
        return flightPlan;
    }

    public Pilot setPilotRating(int pilotRating)
    {
        this.pilotRating = pilotRating;
        return this;
    }

    public int pilotRating()
    {
        return pilotRating;
    }

    public int pilotRatingStringId()
    {
        return Rating.getStringId(pilotRating);
    }

    public Pilot setTransponder(String transponder)
    {
        this.transponder = transponder;
        return this;
    }

    public String transponder()
    {
        return transponder;
    }

    public Pilot setHeading(int heading)
    {
        this.heading = heading;
        return this;
    }

    public int heading()
    {
        return heading;
    }

    public Pilot setOnGround(Boolean onGround)
    {
        this.onGround = onGround;
        return this;
    }

    public Boolean isOnGround()
    {
        return onGround;
    }

    public Pilot setSimulator(int simulator)
    {
        this.simulator = simulator;
        return this;
    }

    public int simulator()
    {
        return simulator;
    }

    public int simulatorStringId()
    {
        return Simulator.getStringId(simulator);
    }

    public Pilot setMtlPlane(String mtlPlane)
    {
        this.mtlPlane = mtlPlane;
        return this;
    }

    public String mtlPlane()
    {
        return mtlPlane;
    }
}
