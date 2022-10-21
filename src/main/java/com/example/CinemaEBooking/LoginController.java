package com.example.CinemaEBooking;

import com.example.CinemaEBooking.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    /*
    @Autowired
    private AccountRepository accountRepo;
    */

    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        model.addAttribute("userLogin", new User());
        return "userLogin";
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public Object submitLoginIn(@ModelAttribute("userLogin") User userForm, Model model) {
        return model; // to be continued

    }
}