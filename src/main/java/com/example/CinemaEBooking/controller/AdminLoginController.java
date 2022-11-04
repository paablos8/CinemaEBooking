package com.example.CinemaEBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Database.DatabaseConnector;

@Controller
public class AdminLoginController {

    DatabaseConnector db = new DatabaseConnector();
    int userId;
    String userType;


    @RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
    public String showAdminLoginPage(ModelMap model) {
        return "adminLogin";
    }

    
    
}
