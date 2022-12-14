package com.example.CinemaEBooking.controller;

import com.example.Database.DatabaseConnector;
import com.example.CinemaEBooking.entities.Customer;
//import Database.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.management.MBeanException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;




@Controller
public class RegistrationController {

    @Autowired
    private JavaMailSender javaMailSender;

    //@Autowired
    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();


    /*public RegistrationController(DatabaseConnector dbConnector) {
        this.dbConnector = dbConnector;
    }*/



    @RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
    public String showRegPage(Model model) {
        model.addAttribute("accountForm", new Customer());
        return "userRegistration";
    }



    @RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
    public Object registerAccount(@ModelAttribute("accountForm") Customer accountForm, BindingResult bindingResult,
                                  Model model, HttpServletRequest request) throws UnsupportedEncodingException, MBeanException {

                                    String firstName = accountForm.getFirstName();
                                    String lastName = accountForm.getLastName();
                                    String street = accountForm.getStreet();
                                    String state = accountForm.getState();
                                    String city = accountForm.getCity();
                                    int zipcode = accountForm.getZipcode();

                                    long phone = accountForm.getPhone();
                                    String email = accountForm.getEmail();
                                    String password = accountForm.getPassword();
                                    Boolean promotionSubscribe = accountForm.getPromotionSubscribe();

        int result = db.createNewUser(firstName, lastName, phone, email, promotionSubscribe, false, password);

        
        if (result == -3) {
            model.addAttribute("message", "You have to enter a first name!");
            return "userRegistration";
        }
        
        if (result == -4) {
            model.addAttribute("message", "You have to enter a last name!");
            return "userRegistration";
        }
        
        if (result == -5) {
            model.addAttribute("message", "You have to enter a password!");
            return "userRegistration";
        }
        
        if (result == -6) {
            model.addAttribute("message", "Registration failed, this email-address is already used by another User!");
            return "userRegistration";
        }

        else {
        int userID = db.verifyLogin(email, password);
        db.createNewAddress(userID, street, city, state, "USA", zipcode);
        System.out.println(result);

        System.out.println("user created with email:" + email + " and password: " + password);
        sendEmail(email);

        return "redirect:/registrationConfirmation";
        }

    
}

void sendEmail(String emailAdress) {

    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setTo(emailAdress);

    msg.setSubject("Account created");
    msg.setText("You have sucessfully created an account for the cinema E-booking system!");

    javaMailSender.send(msg);

}
}