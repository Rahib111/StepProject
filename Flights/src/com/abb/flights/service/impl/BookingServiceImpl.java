package com.abb.flights.service.impl;

import com.abb.flights.dao.BookingDao;
import com.abb.flights.dao.FlightDao;
import com.abb.flights.entity.Booking;
import com.abb.flights.entity.Flight;
import com.abb.flights.exception.NoSeatException;
import com.abb.flights.service.BookingService;

import java.util.List;

public class BookingServiceImpl implements BookingService {
    private final BookingDao bookingDao = new BookingDao();


    @Override
    public List<Booking> getAll() {
        return bookingDao.getAll();
    }

    @Override
    public Booking addBooking(Booking booking) throws NoSeatException {
        return bookingDao.addBooking(booking);
    }

    @Override
    public List<Booking> getByNameAndSurname(String name, String surname) {

        return bookingDao.getByNameAndSurname(name, surname);
    }

    @Override
    public boolean cancelBooking(Integer id) {
        return bookingDao.cancelBooking(id);
    }
}
