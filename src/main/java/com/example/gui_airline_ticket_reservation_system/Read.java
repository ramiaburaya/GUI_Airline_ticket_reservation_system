package com.example.gui_airline_ticket_reservation_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public abstract class Read {
    private static Scanner input = null;
    public static LinkedList<Flight> flightsRecord = new LinkedList<>();

    public static void readFlights(File file) {
        try {
            input = new Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] flightsInfo = line.split(",");

                int flightNumber = Integer.parseInt(flightsInfo[0].trim());
                String arline = flightsInfo[1].trim();
                String sou = flightsInfo[2].trim();
                String des = flightsInfo[3].trim();
                int cap = Integer.parseInt(flightsInfo[4].trim());

                flightsRecord.insert(new Flight(flightNumber, arline, sou, des, cap));

            }
            flightsRecord.sort();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static void readPassengers(File file) {
        try {
            input = new Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] passengerInfo = line.split(",");

                int flightNumber = Integer.parseInt(passengerInfo[0].trim());
                int ticketNumber = Integer.parseInt(passengerInfo[1].trim());
                String fullName = passengerInfo[2].trim();
                String passportNumber = passengerInfo[3].trim();
                String nationality = passengerInfo[4].trim();
                String birthdate = passengerInfo[5].trim();
                Node<Flight> search = flightsRecord.search(new Flight(flightNumber, null,
                        null, null, 0));

                search.getData().getPassengerList().insert(new Passenger(flightNumber, ticketNumber, fullName,
                        passportNumber, nationality, birthdate));
                search.getData().getPassengerList().sort();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

}
