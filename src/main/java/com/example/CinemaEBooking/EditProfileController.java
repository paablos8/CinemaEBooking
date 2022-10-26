package com.example.CinemaEBooking;

import com.example.Database.DatabaseConnector;
import com.example.CinemaEBooking.entities.Customer;
import com.example.CinemaEBooking.entities.Status;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("currentUser")
public class EditProfileController {

    DatabaseConnector db = new DatabaseConnector();    

    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public String showEditProfilePage(ModelMap model) {

        /*
        String firstName = db.getUserFirstName(userId);
        String lastName = db.getUserLastName(userId);
        long phoneNumber = db.getUserPhoneNumber(userId);
        String country = db.getCountry(userId);
        String city = db.getCityCounty(userId);
        String email = db.getUserEmail(userId);
       

        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("country", country);
        model.addAttribute("city", city);
        model.addAttribute("email", email);
        model.addAttribute("userId", userId);
        */
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