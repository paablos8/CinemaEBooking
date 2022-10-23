package com.example.CinemaEBooking.entities;

import java.util.Date;

public class PaymentCard {
    private int cardNumber;
    private String billingAddress;
    private Date expirationDate;
    //private Booking[] bookings; //not consistent to our UML diagram, but I think an array to store the bookings would be more appropriate

    //constructor
    public PaymentCard(int cardNumber, String billingAddress, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.billingAddress = billingAddress;
        this.expirationDate = expirationDate;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /*
    public Booking[] getBookings() {
        return bookings;
    }

    public void setBookings(Booking[] bookings) {
        this.bookings = bookings;
    }
    */

    
}
