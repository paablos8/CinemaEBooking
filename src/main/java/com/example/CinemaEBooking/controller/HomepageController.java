package com.example.CinemaEBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {
    
    @RequestMapping("/")
    public String home (){

        return "redirect:/homePage";
    }

    @RequestMapping("/homePage")
    public String homePage (){

        return "homePage";
    }

    @RequestMapping("/registrationConfirmation")
    public String registrationConfirmation(){

        return "registrationConfirmation";
    }

    @RequestMapping("/orderTicketsFightClub")
    public String orderTicks(){

        return "orderTicketsFightClub";
    }
}