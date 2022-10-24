package com.example.CinemaEBooking;

import com.example.DatabaseConnector;
import com.example.CinemaEBooking.entities.User;
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
    private DatabaseConnector dbConnector = new DatabaseConnector();


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
                                    String billingAddress = accountForm.getBillingAddress();
                                    String email = accountForm.getEmail();
                                    String password = accountForm.getPassword();
                                    Boolean promotionSubscribe = accountForm.getPromotionSubscribe();

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        System.out.println(promotionSubscribe);



     return "/registrationConfirmation";

    
}

void sendEmail(String emailAdress) {

    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setTo(emailAdress);

    msg.setSubject("Account created");
    msg.setText("You have sucessfully created an account for the cinema E-booking system!");

    javaMailSender.send(msg);

}
}