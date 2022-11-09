package com.example.CinemaEBooking.entities;

import java.util.Date;

@Entity(name = "user")
public class User {
    protected int userId;
    private String email;
    private Status status;
    private String password;
    private String firstName;
    private String lastName;
    private long phone;
    private String street;
    private String city;
    private String state;
    private String country;
    private int zipCode;
    private boolean promotionSubscribe;
    private PaymentCard[] paymentCards = {null, null, null};
    
    private PaymentCard[] addPaymentInfo (String nameOnCard, int cardNumber, int cvv, Date expirationDate) {
        PaymentCard paymentCard = new PaymentCard(nameOnCard, cardNumber, cvv, expirationDate);
        
        int i = 0;
        while (i<4) {
            if(paymentCards[i] == null) {
                paymentCards[i] = paymentCard;
            }
            else {
                i = i+1;
            }
        }

        return paymentCards; 
    }
    
    

  //constructor
  public User() {
    this.status = Status.ACTIVE;
}
  
  
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }



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

    public boolean isPromotionSubscribe() {
        return promotionSubscribe;
    }


    public void setPromotionSubscribe(boolean promotionSubscribe) {
        this.promotionSubscribe = promotionSubscribe;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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