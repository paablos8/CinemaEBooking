package com.example.CinemaEBooking.entities;

@Entity(name = "user")
public class User {
    protected int userId;
    private String password;
    private Status status;

    //constructor
    public User() {
            this.status = Status.ACTIVE;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}