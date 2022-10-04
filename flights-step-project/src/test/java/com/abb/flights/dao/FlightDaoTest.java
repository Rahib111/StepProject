package com.abb.flights.dao;

import com.abb.flights.entity.Flight;
import com.abb.flights.util.ControlPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightDaoTest {

    private final FlightDao flightDao = new FlightDao();
    private final  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @BeforeEach
    public void setUp ()
    {
        ControlPanel.startApplication();
    }

    @Test
    public void testGetById() {
        Integer id = 1;

        try {
            Flight expected = getFlight(id, 100, "Turkey");
            Flight actual = flightDao.getById(id);

            assertEquals(expected, actual);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetByDestinationAndFlightDate ()
    {
        String destination = "Turkey";
        Date date = null;
        try {
            date = simpleDateFormat.parse("2022-10-22 21:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Flight expected = getFlight(1, 100, "Turkey");
            Flight actual = flightDao.getByDestinationAndFlightDate(destination, date);

            assertEquals(expected, actual);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private Flight getFlight(Integer id, Integer freeSeats, String destination) throws ParseException {
        return new Flight(id, freeSeats, destination, simpleDateFormat.parse("2022-10-22 21:00:00"));
    }
}