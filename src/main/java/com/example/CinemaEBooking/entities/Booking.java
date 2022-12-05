package com.example.CinemaEBooking.entities;

public class Booking {
    private int child;
    private int adult;
    private int senior;
    private int userID;
    private int ShowID;
    private int cardID;
    private int promoID;
    
    public int getChild() {
        return child;
    }
    public void setChild(int child) {
        this.child = child;
    }
    public int getAdult() {
        return adult;
    }
    public void setAdult(int adult) {
        this.adult = adult;
    }
    public int getSenior() {
        return senior;
    }
    public void setSenior(int senior) {
        this.senior = senior;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getShowID() {
        return ShowID;
    }
    public void setShowID(int showID) {
        ShowID = showID;
    }
    public int getCardID() {
        return cardID;
    }
    public void setCardID(int cardID) {
        this.cardID = cardID;
    }
    public int getPromoID() {
        return promoID;
    }
    public void setPromoID(int promoID) {
        this.promoID = promoID;
    }

    
}
