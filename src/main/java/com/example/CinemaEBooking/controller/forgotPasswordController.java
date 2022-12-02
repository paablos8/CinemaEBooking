package com.example.CinemaEBooking.controller;

import com.example.Database.DatabaseConnector;

import org.springframework.stereotype.Controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.CinemaEBooking.entities.User;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Controller("forgotPasswordController")
public class forgotPasswordController {

    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();
    
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String showForgotPasPage(Model model) {
        model.addAttribute("emailBox", new User());
        return "forgotPassword";
    }

    
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public Object forgotPassword(@ModelAttribute("emailBox") User user, Model model) {
        String email = user.getEmail();
        int loginResult = db.verifyLogin(email, "lol");

        if (loginResult == -1)  {
            System.out.println("succes");
            sendEmail(email);

        }

        return "redirect:/userLogin";
    }

    @Autowired
    private JavaMailSender javaMailSender;

    void sendEmail(String emailAdress) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(emailAdress);

        String encodedString = Base64.getEncoder().encodeToString(emailAdress.getBytes());
    
        msg.setSubject("Password reset link");
        msg.setText("Your password rest link: localhost:8080/resetPassword?id=" + encodedString );
    
        javaMailSender.send(msg);
    
    }


}
