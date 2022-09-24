package com.abb.flights.service.impl;

import com.abb.flights.dao.FlightDao;
import com.abb.flights.entity.Flight;
import com.abb.flights.service.FlightService;

import java.util.Date;
import java.util.List;

public class FlightServiceImpl implements FlightService {
    private final FlightDao flightDao = new FlightDao();

    @Override
    public List<Flight> getAll() {
        return flightDao.getAll();
    }

    @Override
    public Flight getById(Integer id) {
        return flightDao.getById(id);
    }

    @Override
    public List<Flight> getByDestinationId(Integer id) {
        return flightDao.getByDestinationId(id);
    }

    @Override
    public Flight getByDestinationAndFlightDate(String destination, Date date) {
        return flightDao.getByDestinationAndFlightDate(destination, date);
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flightDao.addFlight(flight);
    }
}
