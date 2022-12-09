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
                    
        if (storedPaymentCards.length > 0) {
            long[] numbers = db.getCardNumbers(userId);
            String[] names = db.getCardNames(userId);
            int[] cvvs = db.getCardCVVs(userId);
            String[] expDates = db.getCardExpDates(userId);
            int[] zips = db.getCardZipCodes(userId);

        model.addAttribute("card1Name", names[0]); 
        model.addAttribute("card1Number", numbers[0]);
        model.addAttribute("card1Cvv", cvvs[0]);
        model.addAttribute("card1Expiration",expDates[0]);
        model.addAttribute("card1Zip", zips[0]);

        }

        if (storedPaymentCards.length > 1) {
            
            long[] numbers = db.getCardNumbers(userId);
            String[] names = db.getCardNames(userId);
            int[] cvvs = db.getCardCVVs(userId);
            String[] expDates = db.getCardExpDates(userId);
            int[] zips = db.getCardZipCodes(userId);

        model.addAttribute("card2Name", names[1]);
        model.addAttribute("card2Number",numbers[1]);
        model.addAttribute("card2Cvv",cvvs[1]);
        model.addAttribute("card2Expiration", expDates[1]);
        model.addAttribute("card2Zip", zips[1]);
        }
        
        if (storedPaymentCards.length > 2) {

            long[] numbers = db.getCardNumbers(userId);
            String[] names = db.getCardNames(userId);
            int[] cvvs = db.getCardCVVs(userId);
            String[] expDates = db.getCardExpDates(userId);
            int[] zips = db.getCardZipCodes(userId);

    model.addAttribute("card3Name", names[2]);
    model.addAttribute("card3Number",numbers[2]);
    model.addAttribute("card3Cvv",cvvs[2]);
    model.addAttribute("card3Expiration",expDates[2]);
    model.addAttribute("card3Zip",zips[2]);
    }
        
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

        return "redirect:/viewProfile";
    }


}