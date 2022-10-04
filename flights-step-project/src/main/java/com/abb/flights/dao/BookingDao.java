package com.abb.flights.dao;

import com.abb.flights.entity.Booking;
import com.abb.flights.entity.Flight;
import com.abb.flights.exception.NoSeatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {
    private static final String filePath = "C:\\Users\\VR\\Documents\\flights\\bookings.txt";
    private static final List<Booking> bookingList = new ArrayList<>();

    public Booking addBooking(Booking booking) throws NoSeatException{
        FlightDao flightDao = new FlightDao();

        Integer flightId = booking.getFlight();
        Flight flight = flightDao.getById(flightId);
        if (flight.getFreeSeats().equals(0))
            throw new NoSeatException("There is not enough seats in this flight: " + flightId);

        booking.setId(bookingList.size() + 1);
        bookingList.add(booking);

        flight.setFreeSeats(flight.getFreeSeats() - 1);

        return booking;
    }

    public List<Booking> getAll(){
        return bookingList;
    }

    public boolean cancelBooking(Integer id){
        for(int i = 0; i < bookingList.size(); i ++){
            Booking booking = bookingList.get(i);
            if(booking.getId().equals(id)){
                bookingList.remove(booking);
                return true;
            }
        }
        return false;
    }

    public List<Booking> getByNameAndSurname(String name, String surname){
        List<Booking> bookings = new ArrayList<>();
        for(int i = 0; i < bookingList.size(); i++){
            Booking booking = bookingList.get(i);
            if(booking.getPassengerName().equals(name) && booking.getPassengerSurname().equals(surname)){
                bookings.add(booking);
            }
        }
        return bookings;

    }

    public static void start(){
        File file = new File(filePath);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileInputStream fileInputStream ;
        try{
            fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while(bufferedReader.ready()){
                String line = bufferedReader.readLine();
                String [] arr = line.split("\\|");
                Booking booking = new Booking(Integer.valueOf(arr[0]), arr[1], arr[2],Integer.valueOf(arr[3]));
                bookingList.add(booking);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeData(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < bookingList.size(); i++){
            Booking booking = bookingList.get(i);
            String bookingData = booking.getId() + "|" + booking.getPassengerName() + "|" + booking.getPassengerSurname() + "|" + booking.getFlight() + "\n";
            stringBuilder.append(bookingData);

        }

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
