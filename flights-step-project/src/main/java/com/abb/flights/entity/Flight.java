package com.abb.flights.entity;

import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(getId(), flight.getId()) && Objects.equals(getFreeSeats(), flight.getFreeSeats()) && Objects.equals(getDestination(), flight.getDestination()) && Objects.equals(getFlightDate(), flight.getFlightDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFreeSeats(), getDestination(), getFlightDate());
    }
}
