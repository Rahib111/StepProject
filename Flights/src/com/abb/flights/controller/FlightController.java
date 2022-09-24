package com.abb.flights.controller;

import com.abb.flights.config.Context;
import com.abb.flights.entity.Flight;
import com.abb.flights.service.FlightService;

import java.util.Date;
import java.util.List;

public class FlightController {
    private final FlightService flightService = Context.getFlightService();

    public List<Flight> getAll ()
    {
        return flightService.getAll();
    }

    public Flight getById (Integer id)
    {
        return flightService.getById(id);
    }

    public List<Flight> getByDestinationId (Integer id)
    {
        return flightService.getByDestinationId(id);
    }

    public Flight getByDestinationAndFlightDate(String destination, Date date)
    {
        return flightService.getByDestinationAndFlightDate(destination, date);
    }

    public  Flight addFlight(Flight flight)
    {
        return flightService.addFlight(flight);
    }
}
