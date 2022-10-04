package com.abb.flights.util;

import com.abb.flights.controller.BookingController;
import com.abb.flights.controller.FlightController;
import com.abb.flights.dao.BookingDao;
import com.abb.flights.dao.FlightDao;
import com.abb.flights.entity.Booking;
import com.abb.flights.entity.Flight;
import com.abb.flights.exception.NoSeatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ControlPanel {
    private static FlightController flightController = new FlightController();
    private static BookingController bookingController = new BookingController();

    public static void startApplication() {
        FlightDao.start();
        BookingDao.start();
    }

    public static void onlineBoard() {
        List<Flight> flights = flightController.getAll();
        System.out.println("***********All flights from Kiev*****************");
        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            System.out.println("Id: " + flight.getId());
            System.out.println("Destination: " + flight.getDestination());
            System.out.println("Date: " + flight.getFlightDate());
            System.out.println("Amount of free seats: " + flight.getFreeSeats());
            System.out.println();
        }
    }

    public static void showFlightInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id of flight: ");
        Integer id = scanner.nextInt();
        Flight flight = flightController.getById(id);
        System.out.println("******************Information about flight with id: " + id + "****************************");
        System.out.println("Id: " + flight.getId());
        System.out.println("Destination: " + flight.getDestination());
        System.out.println("Date: " + flight.getFlightDate());
        System.out.println("Amount of free seats: " + flight.getFreeSeats());
        System.out.println();
    }

    public static void searchFlight() {
        System.out.println("*********************Search and Book Flight*****************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Destination: ");
        String destination = scanner.next();
        System.out.print("Date (Please provide date in this format yyyy-MM-dd HH:mm:ss): ");
        String dateString = scanner.nextLine();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Date you entered is not in valid format, please write again in valid format.");
            return;
        }

        System.out.print("Number of people: ");
        Integer people = scanner.nextInt();

        Flight flight = flightController.getByDestinationAndFlightDate(destination, date);

        if (flight.getFreeSeats() >= people) {
            System.out.println("One flight was found: ");
            System.out.println("Id: " + flight.getId());
            System.out.println("Destination: " + flight.getDestination());
            System.out.println("Date: " + flight.getFlightDate());
            System.out.println("Amount of free seats: " + flight.getFreeSeats());
            System.out.println();
        }
    }

    public static void book() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID of flight: ");
        Integer id = scanner.nextInt();
        System.out.print("Name of passenger: ");
        String name = scanner.next();
        System.out.print("Surname of passenger: ");
        String surname = scanner.next();

        Booking booking = new Booking(name, surname, id);
        try {
            bookingController.addBooking(booking);
        } catch (NoSeatException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Your booking successfully added!");
    }

    public static void cancelBooking() {
        System.out.println("**********Cancel booking******************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter booking id: ");
        Integer id = scanner.nextInt();

        boolean isCanceled = bookingController.cancelBooking(id);

        if (isCanceled)
            System.out.println("Your booking successfully cancelled.");
        else
            System.out.println("Something went wrong, please try again.");
    }

    public static void myFlights() {
        System.out.println("************My flights********************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of passenger: ");
        String name = scanner.next();
        System.out.print("Surname of passenger: ");
        String surname = scanner.next();

        List<Booking> bookings = bookingController.getByNameAndSurname(name, surname);
        if (bookings.size() == 0) {
            System.out.println("You have not booking yet.");
            return;
        }

        System.out.println("Your bookings: ");
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            System.out.println("ID: " + booking.getId());
            System.out.println("Name: " + booking.getPassengerName());
            System.out.println("Surname: " + booking.getPassengerSurname());

            Flight flight = flightController.getById(booking.getFlight());
            System.out.println("Flight:");
            System.out.println("Id: " + flight.getId());
            System.out.println("Destination: " + flight.getDestination());
            System.out.println("Date: " + flight.getFlightDate());
            System.out.println("Amount of free seats: " + flight.getFreeSeats());
        }
    }

    public static void addFlight() {
        System.out.println("********************Add flight************************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Destination: ");
        String destination = scanner.next();
        System.out.print("Amount of free seats: ");
        Integer freeSeats = scanner.nextInt();
        System.out.print("Date (Please provide date in this format yyyy-MM-dd HH:mm:ss): ");
        scanner.nextLine();
        String dateString = scanner.nextLine();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Date you entered is not in valid format, please write again in valid format.");
            return;
        }

        Flight flight = new Flight(freeSeats, destination, date);
        flight = flightController.addFlight(flight);
        System.out.println("Added flight:");
        System.out.println("Id: " + flight.getId());
        System.out.println("Destination: " + flight.getDestination());
        System.out.println("Date: " + flight.getFlightDate());
        System.out.println("Amount of free seats: " + flight.getFreeSeats());
    }

    public static void closeApplication() {
        FlightDao.writeData();
        BookingDao.writeData();
        System.exit(0);
    }
}
