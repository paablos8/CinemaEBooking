package com.example.CinemaEBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Database.DatabaseConnector;

@Controller
public class SearchErrorController {

    private DatabaseConnector db = new DatabaseConnector();

    

    @RequestMapping(value = "/searchError", method = RequestMethod.GET)
    public String showSearchErrorPage(Model model) {
        return "searchError";
    }   
}
