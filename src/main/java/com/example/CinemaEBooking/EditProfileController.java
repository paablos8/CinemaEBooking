package com.example.CinemaEBooking;

import com.example.Database.DatabaseConnector;
import com.example.CinemaEBooking.entities.Customer;
import com.example.CinemaEBooking.entities.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditProfileController {

    DatabaseConnector db = new DatabaseConnector();
    Customer customer;
    

    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public String showEditProfilePage(ModelMap model) {
        model.addAttribute("editProfile", customer); //later this has to be the logged in user! We have to identify who is logged in!
        return "editProfile";

    }

    
    
    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
    public Object editProfileSubmit(@ModelAttribute("editCard") User user, Model model) {
        return "editCard";
    }

    //"edit"-button gets pressed & the controller returns the "editCard"-File
    @RequestMapping("/editCard")
    public ModelAndView editCard (ModelAndView model) {
        model.setViewName ("editCard");

        return model;
    }
}