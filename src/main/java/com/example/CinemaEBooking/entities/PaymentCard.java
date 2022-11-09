package com.example.CinemaEBooking.entities;

import java.util.Date;

public class PaymentCard {
    private String nameOnCard;
    private int cardNumber;
    private String billingAddress;
    private int cvv;
    private Date expirationDate;
    
    //private Booking[] bookings; //not consistent to our UML diagram, but I think an array to store the bookings would be more appropriate

//constructor

public PaymentCard (String nameOnCard, int cardNumber, int cvv, Date expirationDate) {
    this.nameOnCard = nameOnCard;
    this.cardNumber = cardNumber;
    this.cvv = cvv;
    this.expirationDate = expirationDate;
}
    
    //getter and setter
    
        public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
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

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
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
