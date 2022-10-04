package com.abb.flights.dao;

import com.abb.flights.entity.Booking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BookingDaoTest {


    @BeforeEach
    void setUp() {
        BookingDao.start();
    }

    @Test
    void cancelBooking() {

    }

    @Test
    void getByNameAndSurname() {
        String passengerName = "Jhon";
        String passengerSurname = "Jack";
        Booking expected = new Booking(1, passengerName, passengerSurname, 1);
        List <Booking> exceptedList = new ArrayList<>();
        exceptedList.add(expected);
        BookingDao bookingDao = new BookingDao();
        List<Booking> actual = bookingDao.getByNameAndSurname(passengerName, passengerSurname);
        Assertions.assertEquals(exceptedList, actual);





    }
}
