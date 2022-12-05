package com.example.CinemaEBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Database.DatabaseConnector;

@Controller
public class ViewCartController {

    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();

    

    @RequestMapping(value = "/viewcart", method = RequestMethod.GET)
    public String showViewCartPage(Model model) {
        return "viewcart";
    }   
    
}
