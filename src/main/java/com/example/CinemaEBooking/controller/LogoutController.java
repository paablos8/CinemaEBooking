package com.example.CinemaEBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class LogoutController {

    @RequestMapping(value = "/logoutSuccess", method = RequestMethod.GET)
    public String showRegPage(Model model) {
        
        return "logoutSuccess";
    }

   
}
