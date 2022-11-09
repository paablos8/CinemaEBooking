package com.example.CinemaEBooking.entities;

public class Customer extends User{
    private String firstName;
    private String lastName;
    private long phone;
    private PaymentCard[] paymentCards;
    
    private String street;
    private String state;
    private String city;
    private int zipcode;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

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

    public boolean getPromotionSubscribe() {
        return promotionSubscribe;
    }

    public void setPromotionSubscribe(boolean promotionSubscribe){
        this.promotionSubscribe = promotionSubscribe;
    }

    public void setPhone(long phone){
        this.phone = phone;
    }

    /*public int getPhone(){
        return phone;
    }
    */
}
