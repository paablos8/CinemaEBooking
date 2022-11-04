package com.example.CinemaEBooking.entities;

import java.sql.Time;
import java.util.Date;

public class Show {
    private int id;
    private Time time;
    private Date date;
    private double duration;

    public Show(int id) {this.id = id;}


    public int getId() {
        return id;
    }

}
