package com.example.gui_airline_ticket_reservation_system;

public class Passenger implements Comparable<Passenger> {
    private int flightNumber;
    private int ticketNumber;
    private String fullName;
    private String passportNumber;
    private String nationality;
    private String birthdate;

    //parametrized Constructor
    public Passenger(int flightNumber, int ticketNumber, String fullName, String passportNumber, String nationality, String birthdate) {
        this.flightNumber = flightNumber;
        this.ticketNumber = ticketNumber;
        this.fullName = fullName;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.birthdate = birthdate;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    //we Override this method because we will search using full name
    @Override
    public boolean equals(Object o) {
        return this.getFullName().equals(((Passenger) o).getFullName());
    }

    // we  Override this because we will insert passenger in linked list sorted
    @Override
    public int compareTo(Passenger o) {
        return this.getFullName().compareTo(o.getFullName());
    }

    @Override
    public String toString() {
        return flightNumber + " " + ticketNumber + " " + fullName + " " + passportNumber + " " + nationality + " " + birthdate + " ";
    }
}
