package com.example.CinemaEBooking.controller;

import com.example.Database.DatabaseConnector;
import com.example.CinemaEBooking.entities.Customer;
import com.example.CinemaEBooking.entities.PaymentCard;
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

    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();    

    @RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
    public String showViewProfilePage(ModelMap model, HttpServletRequest request) {
        model.addAttribute("editAccountForm", new Customer());

        //Get current logged in user
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int userId = currentUser.getUserId();

        //Get Card data
        PaymentCard[] storedPaymentCards = db.createCardObjects(userId);
        for (int i = 0; i < storedPaymentCards.length; i++) {
            model.addAttribute("card" + i, storedPaymentCards[i]);
        }

        PaymentCard card1 = storedPaymentCards[0];
        model.addAttribute("card1Name",card1.getNameOnCard());
        model.addAttribute("card1Number",card1.getCardNumber());
        model.addAttribute("card1Cvv",card1.getCvv());
        model.addAttribute("card1Expiration",card1.getExpirationDate());
        model.addAttribute("card1Zip",card1.getZip());

        System.out.println("New Name on Card: " + card1.getNameOnCard());
        System.out.println("New Card Number: " + card1.getCardNumber());
        System.out.println("New CVV: " + card1.getCvv());
        System.out.println("New Card Expiration Date: " + card1.getExpirationDate());
        System.out.println("New Street Address: " + card1.getStreet());
        System.out.println("New City: " + card1.getCity());
        System.out.println("New State: " + card1.getState());
        System.out.println("New Zip: " + card1.getZip());

        PaymentCard card2 = storedPaymentCards[1];

        model.addAttribute("card2Name",card2.getNameOnCard());
        model.addAttribute("card2Number",card2.getCardNumber());
        model.addAttribute("card2Cvv",card2.getCvv());
        model.addAttribute("card2Expiration",card2.getExpirationDate());
        model.addAttribute("card2Zip",card2.getZip());
        System.out.println("New Name on Card: " + card2.getNameOnCard());
        System.out.println("New Card Number: " + card2.getCardNumber());
        System.out.println("New CVV: " + card2.getCvv());
        System.out.println("New Card Expiration Date: " + card2.getExpirationDate());
        System.out.println("New Street Address: " + card2.getStreet());
        System.out.println("New City: " + card2.getCity());
        System.out.println("New State: " + card2.getState());
        System.out.println("New Zip: " + card2.getZip());    

    PaymentCard card3 = storedPaymentCards[2];
    model.addAttribute("card3Name",card3.getNameOnCard());
    model.addAttribute("card3Number",card3.getCardNumber());
    model.addAttribute("card3Cvv",card3.getCvv());
    model.addAttribute("card3Expiration",card3.getExpirationDate());
    model.addAttribute("card3Zip",card3.getZip());
    System.out.println("New Name on Card: " + card3.getNameOnCard());
    System.out.println("New Card Number: " + card3.getCardNumber());
    System.out.println("New CVV: " + card3.getCvv());
    System.out.println("New Card Expiration Date: " + card3.getExpirationDate());
    System.out.println("New Street Address: " + card3.getStreet());
    System.out.println("New City: " + card3.getCity());
    System.out.println("New State: " + card3.getState());
    System.out.println("New Zip: " + card3.getZip());
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
        System.out.println("This is the user ID: " + userId);

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
        db.changeZipCode(userId, user.getZipCode());


        System.out.println("Following changes made:");
        System.out.println("New First Name: " + db.getUserFirstName(userId));
        System.out.println("New Last Name: " + db.getUserLastName(userId));
        System.out.println("New Phone Number: " + db.getUserPhoneNumber(userId));
        System.out.println("New Street: " + db.getStreetAddress(userId));
        System.out.println("New City: " + db.getCityCounty(userId));
        System.out.println("New State: " + db.getStateRegion(userId));
        System.out.println("New Country: " + db.getCountry(userId));
        System.out.println("New PromotionSubscribe: " + db.getPromoOp(userId));
        System.out.println("New Zip Code: " + db.getZipCode(userId));

        
        return "viewProfile";
    }


}