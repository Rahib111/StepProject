package com.abb.flights.service.impl;

import com.abb.flights.config.Context;
import com.abb.flights.dao.FlightDao;
import com.abb.flights.entity.Flight;
import com.abb.flights.service.FlightService;
import com.abb.flights.util.ControlPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceImplTest {

    private FlightService flightService;
    private FlightDao flightDao;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @BeforeEach
    public void setUp() {

        flightDao = Mockito.mock(FlightDao.class);//new FlightDao()

        flightService = new FlightServiceImpl(flightDao);
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getById() {
        Integer id = 1;

        try {
            Flight expected = getFlight(id, 100, "Turkey");

            Mockito.when(flightDao.getById(id)).thenReturn(expected);

            Flight actual = flightService.getById(id);

            assertEquals(expected, actual);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getByDestinationAndFlightDate() {
    }

    @Test
    public void addFlight() {
    }


    private Flight getFlight(Integer id, Integer freeSeats, String destination) throws ParseException {
        return new Flight(id, freeSeats, destination, simpleDateFormat.parse("2022-10-22 21:00:00"));
    }
}