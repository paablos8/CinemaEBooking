package com.example.CinemaEBooking.entities;

public class Booking {
    private int child;
    private int adult;
    private int senior;
    private int userID;
    private int ShowID;
    private int cardID;
    private int promoID;
    private String promoCode;
   
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }
    private String [] row1;
    private String [] row2;
    private String [] row3;
    private String [] row4;
    
    public String[] getRow2() {
        return row2;
    }
    public void setRow2(String[] row2) {
        this.row2 = row2;
    }
    public String[] getRow3() {
        return row3;
    }
    public void setRow3(String[] row3) {
        this.row3 = row3;
    }
    public String[] getRow4() {
        return row4;
    }
    public void setRow4(String[] row4) {
        this.row4 = row4;
    }
    public String[] getRow1() {
        return row1;
    }
    public void setRow1(String[] row1) {
        this.row1 = row1;
    }
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

    public String getPromoCode() {
        return promoCode;
    }
}