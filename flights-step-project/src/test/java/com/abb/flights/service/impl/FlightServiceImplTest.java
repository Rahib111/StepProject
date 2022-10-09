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
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceImplTest {

    private FlightService flightService;
    private final  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @BeforeEach
    public void setUp() {

        flightService = Context.getFlightService();

        ControlPanel.startApplication();
    }

    @Test
    public void getById() {
        Integer id = 1;

        try {
            Flight expected = getFlight(id, 100, "Turkey");

            Flight actual = flightService.getById(id);

            assertEquals(expected, actual);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getByDestinationAndFlightDate() {
        String destination = "Turkey";
        Date date = null;
        try {
            date = simpleDateFormat.parse("2022-10-22 21:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Flight expected = new Flight(1, 100, destination, date);
        Flight actual = flightService.getByDestinationAndFlightDate(destination, date);

        assertEquals(expected, actual);
    }


    private Flight getFlight(Integer id, Integer freeSeats, String destination) throws ParseException {
        return new Flight(id, freeSeats, destination, simpleDateFormat.parse("2022-10-22 21:00:00"));
    }
}