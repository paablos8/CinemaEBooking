package com.example.CinemaEBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.example.CinemaEBooking.entities.Promotion;
import com.example.Database.DatabaseConnector;

@Controller
public class SendEMailController {

    @Autowired
    private JavaMailSender javaMailSender;

    private DatabaseConnector db = new DatabaseConnector();
    String[] promotionMailAddresses;


    void sendPromotionEmail(String startDate, String expirationDate, int percentOff) {

        SimpleMailMessage msg = new SimpleMailMessage();
        promotionMailAddresses = db.getAllPromotionEmails();
    
        
        for (int i=0; i < promotionMailAddresses.length; i++) {
            System.out.println(promotionMailAddresses[i]);
            msg.setTo(promotionMailAddresses[i]);

            msg.setSubject("New Promotion available");
            msg.setText("A new promotion has just been released!      It is active from " + startDate + "until " + expirationDate + "!  Make sure to get your -" + percentOff + "% when buying your tickets!");
        
            javaMailSender.send(msg);
        }    
    }
    
}
