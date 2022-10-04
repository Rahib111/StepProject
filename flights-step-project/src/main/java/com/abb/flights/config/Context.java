package com.abb.flights.config;

import com.abb.flights.dao.FlightDao;
import com.abb.flights.service.BookingService;
import com.abb.flights.service.FlightService;
import com.abb.flights.service.impl.BookingServiceImpl;
import com.abb.flights.service.impl.FlightServiceImpl;

public class Context {
    public static BookingService getBookingService(){
        return new BookingServiceImpl();
    }
    public static FlightService getFlightService() {
        FlightDao flightDao = new FlightDao();
        return new FlightServiceImpl(flightDao);
    }
}
