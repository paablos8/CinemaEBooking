package com.example.CinemaEBooking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {
    
    @RequestMapping("/")
    public String home (){

        return "homePage";
    }

    @RequestMapping("/homePage")
    public String homePage (){

        return "homePage";
    }
}