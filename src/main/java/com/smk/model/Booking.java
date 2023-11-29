package com.smk.model;

public class Booking extends Model{
    private long id;
    private long scheduleId;
    private String name;
    private double price;

    public void setScheduleId(long scheduleId) {

    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
