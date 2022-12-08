package com.example.CinemaEBooking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.CinemaEBooking.entities.Booking;
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
        model.addAttribute("submitCheckout", new Booking());

        //Get current logged in user
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int userId = currentUser.getUserId();

        //Get show ID the tickets will be booked for
        int showId = (int) session.getAttribute("showId");

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

    System.out.println("This is the showId: " + showId);

    return "viewcart";
}


    //Submit the Checkout
@RequestMapping(value = "/viewcart", method = RequestMethod.POST)
public Object submitCheckout(@ModelAttribute("submitCheckout") Booking booking, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    User currentUser = (User) session.getAttribute("currentUser");
    int userId = currentUser.getUserId();

    

    //Get show ID the tickets will be booked for
    int showId = (Integer) session.getAttribute("showId");

    String promotionCode = booking.getPromoCode();
    String[] allPromotionCodes = db.getAllPromotionCodes();
    boolean promoFound = false;

    System.out.println(promotionCode);

    for (int i = 0; i < allPromotionCodes.length; i++) {
        if (promotionCode.equals(allPromotionCodes[i])) {
            promoFound = true;
        }
    }

    if (promoFound == true) {
        double percentOff = db.getPercentOff(promotionCode);

        double sum = 19.00 * (1-percentOff);

        System.out.println("After Promotion and Tickets: " + sum);
        model.addAttribute("afterPromotion", sum);
        double promotionSaves = 19.00 * percentOff;

        double totalSum = sum * 1.07;
        System.out.println("The Total Sum after Tax is: " + totalSum);
        model.addAttribute("totalSum", totalSum);
        String message = "Your Promotion has been applied! You get " + percentOff + "% and saved $" + promotionSaves;
        model.addAttribute("promotionApplied", message);
        model.addAttribute("totalSum");

        //Create new booking
        int bookingId = db.createNewBooking(userId, userId, promotionCode, showId, 2, 1, 0);
        
        //get the total price
        //double totalPrice = db.getTotal(bookingId);
        double totalPrice = 10;
        System.out.println(totalPrice);
        
        return "redirect:/orderSummary";
        }

    else {

        model.addAttribute("promotionResult", "The used Promotion Code is not valid!");
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
}