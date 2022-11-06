package com.example.gui_airline_ticket_reservation_system;

public class Flight implements Comparable<Flight> {
    private int flightNumber;
    private String airLineName;
    private String source;
    private String destination;
    private int capacity;
    private LinkedList<Passenger> passengerList = new LinkedList<>();


    //parametrized Constructor
    public Flight(int flightNumber, String airLineName, String source, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.airLineName = airLineName;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirLineName() {
        return airLineName;
    }

    public void setAirLineName(String airLineName) {
        this.airLineName = airLineName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LinkedList<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(LinkedList<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    // we Override equals Method because we will search by Flight number
    @Override
    public boolean equals(Object o) {
        return this.getFlightNumber() == ((Flight) o).getFlightNumber();
    }

    public int getLargestTicket() {
        return 0;
    }

    // we Override compareTo Method because we will insert Flight in linked list Sorted
    @Override
    public int compareTo(Flight o) {
        if (this.getFlightNumber() == o.getFlightNumber()) {
            return 0;
        } else if (this.getFlightNumber() > o.getFlightNumber()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return flightNumber + " " + airLineName + " " + source + " " + destination + " " + capacity + "\n";

    }
}
