package com.smk.model;

import java.util.Date;

public class Schedule extends Model{
    private long id;
    private long departureId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDepartureId() {
        return departureId;
    }

    public void setDepartureId(long departureId) {
        this.departureId = departureId;
    }

    public long getArrivalId() {
        return arrivalId;
    }

    public void setArrivalId(long arrivalId) {
        this.arrivalId = arrivalId;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getFlightNumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    private long arrivalId;
    private Date departureDate;
    private String flightnumber;
}
