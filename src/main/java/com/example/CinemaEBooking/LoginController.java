package com.example.CinemaEBooking;

import com.example.DatabaseConnector;
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
   
    DatabaseConnector db = new DatabaseConnector();

    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        model.addAttribute("login", new User());
        return "userLogin";
    }

    
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public Object submitLoginIn(@ModelAttribute("login") User userForm, Model model) {
        String email = userForm.getEmail();
        String password = userForm.getPassword();

        int loginResult = db.verifyLogin(email, password);

        switch(loginResult)
        {
            case(0):System.out.println("Login successful");
            return "/loginSuccess";
            case(-1):System.out.println("Incorrect password");
            break;
            case(-2):System.out.println("Email not found");
            break;
            default:System.out.println("Something went wrong");
        }
        return "/userLogin";

   }
    

    //"Sign-in"-button gets pressed & the controller returns the "loginSuccess"-File
    @RequestMapping("/loginSuccess")
    public ModelAndView loginSuccess (ModelAndView model) {
        model.setViewName ("loginSuccess");

        return model;
    }
    
}