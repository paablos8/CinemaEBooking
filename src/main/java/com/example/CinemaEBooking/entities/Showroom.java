package com.example.CinemaEBooking.entities;

public class Showroom {
    private int totalSeats;
    private Seat[] seats;

    public Showroom(int totalSeats, Seat[] seats) {
        this.totalSeats = totalSeats;
        this.seats = seats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

}
