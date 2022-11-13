package com.example.CinemaEBooking.controller;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderTicketsController {
    @RequestMapping("/orderTickets")
    public String orderTicks(){

        return "orderTickets";
    }
}
