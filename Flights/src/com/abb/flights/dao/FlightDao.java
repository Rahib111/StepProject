package com.abb.flights.dao;

import com.abb.flights.entity.Flight;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDao {
    private static final String filePath = "C:\\Users\\VR\\Documents\\flights\\flights.txt";
    private static final List<Flight> flights = new ArrayList<>();
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public List<Flight> getAll(){
        return flights;
    }
    public Flight getById(Integer id){
        for (int i = 0; i < flights.size(); i++)
        {
            Flight flight = flights.get(i);
            if (flight.getId().equals(id))
                return flight;
        }
        return null;
    }
    public List<Flight> getByDestinationId(Integer id){
        List<Flight> flightArrayList = new ArrayList<>();
        for(int i = 0; i < flights.size(); i++){
            Flight flight = flights.get(i);
            if(flight.getDestination().equals(id)){
                flightArrayList.add(flight);

            }
        }
        return flightArrayList;
    }
    public Flight getByDestinationAndFlightDate(String destination, Date date){
        for(int i = 0; i < flights.size(); i++){
            Flight flight = flights.get(i);
            if(flight.getDestination().equals(destination) && flight.getFlightDate().equals(date)){
                return flight;
            }
        }
        return null;
    }
    public Flight addFlight(Flight flight){
        flight.setId(flights.size() + 1);
        flights.add(flight);
        return flight;
    }

    public static void start(){
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while(bufferedReader.ready()){
                String line = bufferedReader.readLine();//131|12|343|2022-09-23 20:48:04
                String[] arr = line.split("\\|");

                Flight flight = new Flight(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]), arr[2], simpleDateFormat.parse(arr[3]));
                flights.add(flight);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeData ()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < flights.size(); i++)
        {
            Flight flight = flights.get(i);
            String data = flight.getId() + "|" + flight.getFreeSeats() + "|" + flight.getDestination() + "|"
                    + simpleDateFormat.format(flight.getFlightDate()) + "\n";
            stringBuilder.append(data);
        }

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
