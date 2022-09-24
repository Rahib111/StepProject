package com.abb.flights.entity;

import java.util.Date;

public class Flight {
    private Integer id;
    private Integer freeSeats;
    private String destination;
    private Date flightDate;


    public Flight() {
    }

    public Flight(Integer freeSeats, String destination, Date flightDate) {
        this.freeSeats = freeSeats;
        this.destination = destination;
        this.flightDate = flightDate;
    }

    public Flight(Integer id, Integer freeSeats, String destination, Date flightDate) {
        this.id = id;
        this.freeSeats = freeSeats;
        this.destination = destination;
        this.flightDate = flightDate;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(Integer freeSeats) {
        this.freeSeats = freeSeats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSerialNumber(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightDate=" + flightDate +
                ", destination=" + destination +
                ", freeSeats=" + freeSeats +
                ", id='" + id + '\'' +
                '}';
    }
}
