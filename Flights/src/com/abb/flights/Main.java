package com.abb.flights;

import com.abb.flights.exception.WrongOperationException;
import com.abb.flights.util.ControlPanel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControlPanel.startApplication();
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to flights. Which action you want to do?\n" +
                    "1. Online board\n" +
                    "2. Show the flight info\n" +
                    "3. Search flight\n" +
                    "4. Book flight\n" +
                    "5. Cancel booking\n" +
                    "6. My flights\n" +
                    "7. Add flight\n" +
                    "8. Exit");
            int operation = scanner.nextInt();

            try {
                switch (operation) {
                    case 1:
                        ControlPanel.onlineBoard();
                        break;
                    case 2:
                        ControlPanel.showFlightInfo();
                        break;
                    case 3:
                        ControlPanel.searchFlight();
                        break;
                    case 4:
                        ControlPanel.book();
                        break;
                    case 5:
                        ControlPanel.cancelBooking();
                        break;
                    case 6:
                        ControlPanel.myFlights();
                        break;
                    case 7:
                        ControlPanel.addFlight();
                        break;
                    case 8:
                        ControlPanel.closeApplication();
                        break;
                    default:
                        throw new WrongOperationException("Choose valid operation.");
                }
            } catch (WrongOperationException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
