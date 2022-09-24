package com.abb.flights.entity;

public class Booking {
    private Integer id;
    private String passengerName;
    private String passengerSurname;
    private Integer flight;

    public Booking() {
    }

    public Booking(String passengerName, String passengerSurname, Integer flight) {
        this.passengerName = passengerName;
        this.passengerSurname = passengerSurname;
        this.flight = flight;
    }

    public Booking(Integer id, String passengerName, String passengerSurname, Integer flight) {
        this.passengerName = passengerName;
        this.passengerSurname = passengerSurname;
        this.flight = flight;
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerSurname() {
        return passengerSurname;
    }

    public void setPassengerSurname(String passengerSurname) {
        this.passengerSurname = passengerSurname;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "passengerName='" + passengerName + '\'' +
                ", passengerSurname='" + passengerSurname + '\'' +
                ", flight=" + flight +
                ", id='" + id + '\'' +
                '}';
    }
}
