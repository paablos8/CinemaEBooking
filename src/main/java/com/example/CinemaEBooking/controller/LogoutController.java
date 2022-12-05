package com.example.CinemaEBooking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import com.example.CinemaEBooking.entities.User;

import org.springframework.stereotype.Controller;

@Controller
public class LogoutController {

    @RequestMapping(value = "/logoutSuccess", method = RequestMethod.GET)
    public String showRegPage(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
       session.setAttribute("currentUser", null);
        return "logoutSuccess";
    }

   
}
