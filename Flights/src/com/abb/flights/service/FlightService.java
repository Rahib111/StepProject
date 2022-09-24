package com.abb.flights.service;

import com.abb.flights.entity.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {
    List<Flight> getAll();

    Flight getById(Integer id);

    List<Flight> getByDestinationId(Integer id);

    Flight getByDestinationAndFlightDate(String destination, Date date);

    Flight addFlight(Flight flight);
}
