package com.example.CinemaEBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PromotionHomeController {

    @RequestMapping(value = "/promotionHome", method = RequestMethod.GET)
    public String showPromotionHomePage(ModelMap model) {
        return "promotionHome";
    }
    
}
