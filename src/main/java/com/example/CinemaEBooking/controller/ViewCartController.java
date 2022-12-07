package com.example.CinemaEBooking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.CinemaEBooking.entities.PaymentCard;
import com.example.CinemaEBooking.entities.User;
import com.example.Database.DatabaseConnector;

@Controller
@SessionAttributes("currentUser")
public class ViewCartController {

    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();

    

    @RequestMapping(value = "/viewcart", method = RequestMethod.GET)
    public String showViewCartPage(Model model, HttpServletRequest request) {


        //Get current logged in user
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int userId = currentUser.getUserId();

        //Get Card data
        PaymentCard[] storedPaymentCards = db.createCardObjects(userId);
                    
        if (storedPaymentCards.length > 0) {
            model.addAttribute("noCardStored", "You have currently no Card stored in your Account!");
        }
        
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





        return "viewcart";
    }   


    
}
