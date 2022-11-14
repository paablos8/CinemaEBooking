package com.example.CinemaEBooking.entities;

public class Promotion {
    private int percentOff;
    private String startDate;
    private String expirationDate;
    private String code;

   

    //Getter and Setter
    public int getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(int percentOff) {
        this.percentOff = percentOff;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
