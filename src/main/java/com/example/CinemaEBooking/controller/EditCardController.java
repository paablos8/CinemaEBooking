package com.example.CinemaEBooking.controller;

import java.io.UnsupportedEncodingException;

import javax.management.MBeanException;
import javax.print.DocFlavor.URL;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.CinemaEBooking.entities.Movie;
import com.example.CinemaEBooking.entities.PaymentCard;
import com.example.Database.DatabaseConnector;

import org.springframework.stereotype.Controller;

@Controller
public class EditCardController {


    DatabaseConnector db = new DatabaseConnector();
    
    @RequestMapping(value = "/editCard", method = RequestMethod.GET)
    public String showEditCardPage( ModelMap model) {
        model.addAttribute("editCardForm", new PaymentCard());
        return "editCard";
    }
}
