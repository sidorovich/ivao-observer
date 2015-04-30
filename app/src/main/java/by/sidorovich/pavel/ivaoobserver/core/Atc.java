package by.sidorovich.pavel.ivaoobserver.core;

import java.util.Date;

import by.sidorovich.pavel.ivaoobserver.core.atc.FacilityType;
import by.sidorovich.pavel.ivaoobserver.core.atc.Rating;

public class Atc extends NetworkClient
{
    protected String frequency;
    protected int facilityType;
    protected int atcRating;
    protected int visualRange;
    protected String atis;
    protected Date atisTime;

    public Atc setFrequency(String frequency)
    {
        this.frequency = frequency;
        return this;
    }

    public String frequency()
    {
        return frequency;
    }

    public Atc setFacilityType(int facilityType)
    {
        this.facilityType = facilityType;
        return this;
    }

    public int facilityType()
    {
        return facilityType;
    }

    public int facilityTypeStringId()
    {
        return FacilityType.getStringId(facilityType);
    }

    public Atc setAtcRating(int atcRating)
    {
        this.atcRating = atcRating;
        return this;
    }

    public int atcRating()
    {
        return atcRating;
    }

    public int atcRatingStringId()
    {
        return Rating.getStringId(atcRating);
    }

    public Atc setVisualRange(int visualRange)
    {
        this.visualRange = visualRange;
        return this;
    }

    public int visualRange()
    {
        return visualRange;
    }

    public Atc setAtis(String atis)
    {
        this.atis = atis;
        return this;
    }

    public String atis()
    {
        return atis;
    }

    public Atc setAtisTime(Date atisTime)
    {
        this.atisTime = atisTime;
        return this;
    }

    public Date atisTime()
    {
        return atisTime;
    }
}
