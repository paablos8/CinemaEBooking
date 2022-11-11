package com.example.CinemaEBooking.controller;


import java.io.UnsupportedEncodingException;

import javax.management.MBeanException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.CinemaEBooking.entities.Promotion;
import com.example.Database.DatabaseConnector;

@Controller
public class AddPromotionController {

    private DatabaseConnector db = new DatabaseConnector();

    

    @RequestMapping(value = "/addPromotion", method = RequestMethod.GET)
    public String showAddPromotionPage(Model model) {
    model.addAttribute("addPromotionForm", new Promotion());
        return "addPromotion";
    }    
}
