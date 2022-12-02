package com.example.CinemaEBooking.entities;

import java.util.Date;

import com.example.Database.DatabaseConnector;

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

    
    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();

    private PaymentCard[] addPaymentInfo (int userId, String nameOnCard, long cardNumber, int cvv, String expirationDate, String street, String city, String state, int zip) {
        db.createNewCard(expirationDate, cvv, cardNumber, nameOnCard, userId, street, city, state, "country - tbd", zip);
        
        PaymentCard paymentCard = new PaymentCard();
        
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

    public int getZipCode() {
        return zipCode;
    }


    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


    public boolean getPromotionSubscribe() {
        return promotionSubscribe;
    }

    public void setPromotionSubscribe(boolean promotionSubscribe) {
        this.promotionSubscribe = promotionSubscribe;
    }

    public PaymentCard[] getPaymentCards() {
        return paymentCards;
    }



    public void setPaymentCards(PaymentCard[] paymentCards) {
        this.paymentCards = paymentCards;
    }

}