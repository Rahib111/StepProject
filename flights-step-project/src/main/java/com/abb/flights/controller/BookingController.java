package com.abb.flights.controller;

import com.abb.flights.config.Context;
import com.abb.flights.entity.Booking;
import com.abb.flights.exception.NoSeatException;
import com.abb.flights.service.BookingService;

import java.util.List;

public class BookingController {

    private final BookingService bookingService = Context.getBookingService();

    public List<Booking> getAll(){
        return bookingService.getAll();
    }
    public Booking addBooking(Booking booking) throws NoSeatException {
        return bookingService.addBooking(booking);
    }
    public List<Booking> getByNameAndSurname(String name, String surname){
        return bookingService.getByNameAndSurname(name, surname);
    }
    public boolean cancelBooking(Integer id){
        return bookingService.cancelBooking(id);
    }

}
