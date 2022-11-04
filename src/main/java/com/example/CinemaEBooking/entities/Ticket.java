package com.example.CinemaEBooking.entities;

public class Ticket {
    private double ticketPrice;
    private TicketType ticketType;

    //constructor
    public Ticket(double ticketPrice, TicketType ticketType) {
        this.ticketPrice = ticketPrice;
        this.ticketType = ticketType;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    
}
