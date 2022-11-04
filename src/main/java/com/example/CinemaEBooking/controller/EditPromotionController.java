package com.example.CinemaEBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditPromotionController {

    @RequestMapping(value = "/editPromotion", method = RequestMethod.GET)
    public String showAddPromotionPage(ModelMap model) {
        return "editPromotion";
    }
}
