package com.example.CinemaEBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordResetSentController {

    @RequestMapping(value = "/passwordResetSent", method = RequestMethod.GET)
    public String showPasswordResetSentPage(Model model) {
        return "/passwordResetSent";
    }
    
}
