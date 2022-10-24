package com.example.CinemaEBooking;

import com.example.Database.DatabaseConnector;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.CinemaEBooking.entities.User;

@Controller
public class forgotPasswordController {

    DatabaseConnector db = new DatabaseConnector();
    
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String showForgotPasPage(Model model) {
        model.addAttribute("emailBox", new User());
        return "forgotPassword";
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public Object forgotPassword(@ModelAttribute("emailBox") User user, Model model) {
        String email = user.getEmail();
        int loginResult = db.verifyLogin(email, "lol");

        if (loginResult == -1)  {
            System.out.println("succes");

        }

        
        
        return "homePage";
}
}
