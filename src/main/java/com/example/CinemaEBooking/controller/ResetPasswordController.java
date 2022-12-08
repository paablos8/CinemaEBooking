package com.example.CinemaEBooking.controller;

import java.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.example.CinemaEBooking.entities.User;
import com.example.Database.DatabaseConnector;




@Controller
public class ResetPasswordController {
    
    String para;
    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();

   // @ResponseBody
    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    public String showResetPage(Model model,@RequestParam String id) {
        model.addAttribute("resetPassword", new User());
        para = id;
        return "resetPassword";
    }

    



    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public Object resetPassword(@ModelAttribute("resetPassword") User user, Model model) {
        String password = user.getPassword();
        byte[] decodedBytes = Base64.getDecoder().decode(para);
        String email = new String(decodedBytes);
        System.out.println(email);
        System.out.println(password);
        db.resetPassword(email, password);
        return "redirect:/userLogin";
    }
}

