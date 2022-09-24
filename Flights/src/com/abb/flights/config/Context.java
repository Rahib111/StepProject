package com.abb.flights.config;

import com.abb.flights.service.BookingService;
import com.abb.flights.service.FlightService;
import com.abb.flights.service.impl.BookingServiceImpl;
import com.abb.flights.service.impl.FlightServiceImpl;

public class Context {
    public static BookingService getBookingService(){
        return new BookingServiceImpl();
    }
    public static FlightService getFlightService() {
        return new FlightServiceImpl();
    }
}
