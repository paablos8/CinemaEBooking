package com.example.CinemaEBooking.controller;


import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.CinemaEBooking.entities.Movie;
import com.example.Database.DatabaseConnector;
import org.springframework.stereotype.Controller;

@Controller
public class OrderHistoryController {
    DatabaseConnector db = DatabaseConnector.getInstance();
    
    @RequestMapping(value = "/orderHistory", method = RequestMethod.GET)
    public String showOrderHistory(ModelMap model) {
        
        


       
        return "orderHistory";
    }
}
