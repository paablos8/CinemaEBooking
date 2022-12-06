package com.example.CinemaEBooking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.CinemaEBooking.entities.PaymentCard;
import com.example.CinemaEBooking.entities.User;
import com.example.Database.DatabaseConnector;



@Controller
@SessionAttributes("currentUser")
public class EditCardController {

    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();

    PaymentCard[] storedPaymentCards = new PaymentCard[3];

    
//Edit Card 1:

    //Mapping the "editCard"-page.
    @RequestMapping(value = "/editCardOne", method = RequestMethod.GET)
    public String showEditCardOnePage(ModelMap model, HttpServletRequest request) {
        model.addAttribute("editCardOne", new PaymentCard());

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int userId = currentUser.getUserId();
        return "editCardOne";
    }


//Submit the changes made to the profile.
    @RequestMapping(value = "/editCardOne", method = RequestMethod.POST)
    public Object editCardOneSubmit(@ModelAttribute("editCardOne") PaymentCard card1, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int userId = currentUser.getUserId();

            String name = card1.getNameOnCard();
            long number = card1.getCardNumber();
            int cvv = card1.getCvv();
            String expDate = card1.getExpirationDate();
            String street = card1.getStreet();
            String city = card1.getCity();
            String state = card1.getState();
            String country = card1.getCountry();
            int zip = card1.getZip();
        db.createNewCard(expDate, cvv, number, name, userId, street, city, state, country, zip);
           
        long[] numbers = db.getCardNumbers(userId);
        String[] names = db.getCardNames(userId);
        int[] cvvs = db.getCardCVVs(userId);
        String[] expDates = db.getCardExpDates(userId);
        String[] streets = db.getCardStreetAddress(userId);
        String[] cities = db.getCardCityCounty(userId);
        String[] states = db.getCardStateRegion(userId);
        int[] zips = db.getCardZipCodes(userId);

            System.out.println("Following changes made:");
            System.out.println("New Name on Card: " + numbers[0]);
            System.out.println("New Card Number: " + names[0]);
            System.out.println("New CVV: " + cvvs[0]);
            System.out.println("New Card Expiration Date: " + expDates[0]);
            System.out.println("New Street Address: " + streets[0]);
            System.out.println("New City: " + cities[0]);
            System.out.println("New State: " + states[0]);
            System.out.println("New Zip: " + zips[0]);

        return "viewProfile";
    }


    //Edit Card 2:

    //Mapping the "editCard"-page.
    @RequestMapping(value = "/editCardTwo", method = RequestMethod.GET)
    public String showEditCardTwoPage(ModelMap model, HttpServletRequest request) {
        model.addAttribute("editCardTwo", new PaymentCard());

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int userId = currentUser.getUserId();
       
        return "editCardTwo";
    }


//Submit the changes made to the profile.
@RequestMapping(value = "/editCardTwo", method = RequestMethod.POST)
public Object editCardTwoSubmit(@ModelAttribute("editCardTwo") PaymentCard card2, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    User currentUser = (User) session.getAttribute("currentUser");
    int userId = currentUser.getUserId();


    //get values from form for card 2.
            String name = card2.getNameOnCard();
            long number = card2.getCardNumber();
            int cvv = card2.getCvv();
            String expDate = card2.getExpirationDate();
            String street = card2.getStreet();
            String city = card2.getCity();
            String state = card2.getState();
            String country = card2.getCountry();
            int zip = card2.getZip();
        db.createNewCard(expDate, cvv, number, name, userId, street, city, state, country, zip);
           
        long[] numbers = db.getCardNumbers(userId);
        String[] names = db.getCardNames(userId);
        int[] cvvs = db.getCardCVVs(userId);
        String[] expDates = db.getCardExpDates(userId);
        String[] streets = db.getCardStreetAddress(userId);
        String[] cities = db.getCardCityCounty(userId);
        String[] states = db.getCardStateRegion(userId);
        int[] zips = db.getCardZipCodes(userId);

            System.out.println("Following changes made:");
            System.out.println("New Name on Card: " + numbers[1]);
            System.out.println("New Card Number: " + names[1]);
            System.out.println("New CVV: " + cvvs[1]);
            System.out.println("New Card Expiration Date: " + expDates[1]);
            System.out.println("New Street Address: " + streets[1]);
            System.out.println("New City: " + cities[1]);
            System.out.println("New State: " + states[1]);
            System.out.println("New Zip: " + zips[1]);

    return "viewProfile";

    }


    //Edit Card 3:

    //Mapping the "editCard"-page.
    @RequestMapping(value = "/editCardThree", method = RequestMethod.GET)
    public String showEditCardThreePage(ModelMap model, HttpServletRequest request) {
        model.addAttribute("editCardThree", new PaymentCard());

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int userId = currentUser.getUserId();

        return "editCardThree";

    }


//Submit the changes made to the profile.
@RequestMapping(value = "/editCardThree", method = RequestMethod.POST)
public Object editCardThreeSubmit(@ModelAttribute("editCardThree") PaymentCard card3, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    User currentUser = (User) session.getAttribute("currentUser");
    int userId = currentUser.getUserId();

    //get values from form for card 3.
    String name = card3.getNameOnCard();
            long number = card3.getCardNumber();
            int cvv = card3.getCvv();
            String expDate = card3.getExpirationDate();
            String street = card3.getStreet();
            String city = card3.getCity();
            String state = card3.getState();
            String country = card3.getCountry();
            int zip = card3.getZip();
        db.createNewCard(expDate, cvv, number, name, userId, street, city, state, country, zip);
           
        long[] numbers = db.getCardNumbers(userId);
        String[] names = db.getCardNames(userId);
        int[] cvvs = db.getCardCVVs(userId);
        String[] expDates = db.getCardExpDates(userId);
        String[] streets = db.getCardStreetAddress(userId);
        String[] cities = db.getCardCityCounty(userId);
        String[] states = db.getCardStateRegion(userId);
        int[] zips = db.getCardZipCodes(userId);

            System.out.println("Following changes made:");
            System.out.println("New Name on Card: " + numbers[2]);
            System.out.println("New Card Number: " + names[2]);
            System.out.println("New CVV: " + cvvs[2]);
            System.out.println("New Card Expiration Date: " + expDates[2]);
            System.out.println("New Street Address: " + streets[2]);
            System.out.println("New City: " + cities[2]);
            System.out.println("New State: " + states[2]);
            System.out.println("New Zip: " + zips[2]);

    return "loginSuccess";

    }
}

