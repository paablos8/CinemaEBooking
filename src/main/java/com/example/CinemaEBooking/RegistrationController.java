package com.example.CinemaEBooking;

import com.example.DatabaseConnector;
import com.example.CinemaEBooking.entities.User;
//import Database.*;

import java.io.UnsupportedEncodingException;

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

@Controller
public class RegistrationController {

    //@Autowired
    private DatabaseConnector dbConnector = new DatabaseConnector();


    /*public RegistrationController(DatabaseConnector dbConnector) {
        this.dbConnector = dbConnector;
    }*/



    @RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
    public String showRegPage(Model model) {
        model.addAttribute("accountForm", new DatabaseConnector());
        return "userRegistration";
    }

    @RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
    public Object registerAccount(@ModelAttribute("accountForm") DatabaseConnector accountForm, BindingResult bindingResult,
                                  Model model, HttpServletRequest request) throws UnsupportedEncodingException, MBeanException {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

     return "/registrationConfirmation";

    
}
}