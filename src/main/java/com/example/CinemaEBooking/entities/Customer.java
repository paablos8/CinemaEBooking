package com.example.CinemaEBooking.entities;

public class Customer extends User{
    private String firstName;
    private String lastName;
    private PaymentCard[] paymentCards;
    private String billingAddress;
    private boolean promotionSubscribe;
    //private Booking[] bookings;


    //constructor
    /*public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        PaymentCard[] paymentCards = new PaymentCard[3];
    }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    */

    public PaymentCard[] getPaymentCards() {
        return paymentCards;
    }

    public void setPaymentCards(PaymentCard[] paymentCards) {
        this.paymentCards = paymentCards;
    }

    /*
    public Booking[] getBookings() {
        return bookings;
    }

    public void setBookings(Booking[] bookings) {
        this.bookings = bookings;
    }
    */

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public boolean getPromotionSubscribe() {
        return promotionSubscribe;
    }

    public void setPromotionSubscribe(boolean promotionSubscribe){
        this.promotionSubscribe = promotionSubscribe;
    }

    
}
