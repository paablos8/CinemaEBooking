package com.example.CinemaEBooking;

import com.example.CinemaEBooking.entities.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    /*
    @Autowired
    private AccountRepository accountRepo;
    */
    

    @RequestMapping(value = "/loginDonovan", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        model.addAttribute("login", new User());
        return "loginDonovan";
    }

    
    @RequestMapping(value = "/loginDonovan", method = RequestMethod.POST)
    public Object submitLoginIn(@ModelAttribute("login") User userForm, Model model) {
        String email = userForm.getEmail();
        String password = userForm.getPassword();
        
        if (email == "test@uga.edu") {
            System.out.println("Right email entered:" + email);
            return "loginDonovan";
        }
        if(password == "one") {
            System.out.println("Right password entered:" + password);
            return "loginDonovan";
        }

        else
        return "loginDonovan";

    }
    

    //"Sign-in"-button gets pressed & the controller returns the "loginSuccess"-File
    @RequestMapping("/loginSuccess")
    public ModelAndView loginSuccess (ModelAndView model) {
        model.setViewName ("loginSuccess");

        return model;
    }
    
    
}