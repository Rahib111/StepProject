package com.abb.flights.service;

import com.abb.flights.dao.FlightDao;
import com.abb.flights.entity.Booking;
import com.abb.flights.entity.Flight;
import com.abb.flights.exception.NoSeatException;

import java.util.List;

public interface BookingService {
    List<Booking> getAll();
    Booking addBooking(Booking booking) throws NoSeatException;

    List<Booking> getByNameAndSurname(String name, String surname);

    boolean cancelBooking(Integer id);


}
