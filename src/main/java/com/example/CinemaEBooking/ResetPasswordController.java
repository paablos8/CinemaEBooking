package com.example.CinemaEBooking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.CinemaEBooking.entities.User;


@Controller
public class ResetPasswordController {
    
    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    public String showResetPage(Model model) {
        model.addAttribute("resetPassword", new User());
        return "resetPassword";
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public Object resetPassword(@ModelAttribute("resetPassword") User password, Model model) {
        String password = password.getPassword();
        return "login";
    }
}
