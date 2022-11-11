package com.example.CinemaEBooking.controller;

import com.example.Database.DatabaseConnector;
import com.example.CinemaEBooking.entities.Customer;
import com.example.CinemaEBooking.entities.Status;
import com.example.CinemaEBooking.entities.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
    public String showViewProfilePage(ModelMap model) {
        model.addAttribute("editAccountForm", new Customer());
        return "viewProfile";
    }

  

    //"edit"-button gets pressed & the controller returns the "editCard"-File
    @RequestMapping("/editCard")
    public ModelAndView editCard (ModelAndView model) {
        model.setViewName ("editCard");

        return model;
    }


//Mapping the "editProfile"-page
    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public String showEditProfilePage(ModelMap model, HttpServletRequest request) {
        model.addAttribute("editAccountForm", new Customer());

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int userId = currentUser.getUserId();
        long phone = db.getUserPhoneNumber(userId);
        System.out.println("This is the user ID: " + userId);
        System.out.println("This is the phone number:" + phone);

        return "editProfile";
    }

      
//Submit the changes made to the profile
    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
    public Object editProfileSubmit(@ModelAttribute("editAccountForm") User user, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int userId = currentUser.getUserId();
        System.out.println("This is the user ID: " + userId);

        db.changeFirstName(userId, user.getFirstName());
        db.changeLastName(userId, user.getLastName());
        db.changePhoneNumber(userId, user.getPhone());
        db.changeStreetAddress(userId, user.getStreet());
        db.changeCityCounty(userId, user.getCity());
        db.changeStateRegion(userId, user.getState());
        db.changeCountry(userId, user.getCountry());
        db.changePromotionOpinion(userId, user.getPromotionSubscribe());


        System.out.println("Following changes made:");
        System.out.println("New First Name: " + db.getUserFirstName(userId));
        System.out.println("New Last Name: " + db.getUserLastName(userId));
        System.out.println("New Phone Number: " + db.getUserPhoneNumber(userId));
        System.out.println("New Street: " + db.getStreetAddress(userId));
        System.out.println("New City: " + db.getCityCounty(userId));
        System.out.println("New State: " + db.getStateRegion(userId));
        System.out.println("New Country: " + db.getCountry(userId));
        System.out.println("New PromotionSubscribe: " + db.getPromoOp(userId));

        
        return "editProfile";
    }


}