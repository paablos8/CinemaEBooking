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
        System.out.println("This is the user ID: " + userId);

        //Get Card data
        PaymentCard[] storedPaymentCards = db.createCardObjects(userId);
        if (storedPaymentCards.length > 0) {
            model.addAttribute("card" + 1, storedPaymentCards[0]);
        }
        return "editCardOne";
    }


//Submit the changes made to the profile.
    @RequestMapping(value = "/editCardOne", method = RequestMethod.POST)
    public Object editCardOneSubmit(@ModelAttribute("editCardOne") PaymentCard card1, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int userId = currentUser.getUserId();

        //get all currently stored card numbers from the database.
        PaymentCard[] storedPaymentCards = db.createCardObjects(userId);

        //get values from form for card 1.
            //model.addAttribute("card" + 1, storedPaymentCards[0]);
            long cardNumber = card1.getCardNumber();
        
            db.changeCardName(cardNumber, card1.getNameOnCard());
            db.changeCardNumber(cardNumber, card1.getCardNumber());
            db.changeCardCVV(cardNumber, card1.getCvv());
            db.changeCardExpDate(cardNumber, card1.getExpirationDate());
            //db.changeStreetAddress(cardNumber, card1.getStreet());
            //db.changeCityCounty(cardNumber, card1.getCity());
            db.changeStateRegion(cardNumber, card1.getState());
            db.changeZipCode(cardNumber, card1.getZip());
            
            System.out.println("Following changes made:");
            System.out.println("New Name on Card: " + card1.getNameOnCard());
            System.out.println("New Card Number: " + card1.getCardNumber());
            System.out.println("New CVV: " + card1.getCvv());
            System.out.println("New Card Expiration Date: " + card1.getExpirationDate());
            System.out.println("New Street Address: " + card1.getStreet());
            System.out.println("New City: " + card1.getCity());
            System.out.println("New State: " + card1.getState());
            System.out.println("New Zip: " + card1.getZip());

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

        //Get Card data
        PaymentCard[] storedPaymentCards = db.createCardObjects(userId);
        if (storedPaymentCards.length > 1) {
            model.addAttribute("card" + 2, storedPaymentCards[1]);
            long cardNumber = storedPaymentCards[1].getCardNumber();
        }
        return "editCardTwo";

    }


//Submit the changes made to the profile.
@RequestMapping(value = "/editCardTwo", method = RequestMethod.POST)
public Object editCardTwoSubmit(@ModelAttribute("editCardTwo") PaymentCard card2, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    User currentUser = (User) session.getAttribute("currentUser");
    int userId = currentUser.getUserId();


    //get values from form for card 2.
    PaymentCard[] storedPaymentCards = db.createCardObjects(userId);
    model.addAttribute("card" + 2, storedPaymentCards[1]);
    long cardNumber = storedPaymentCards[1].getCardNumber();

    db.changeCardName(cardNumber, card2.getNameOnCard());
    db.changeCardNumber(cardNumber, card2.getCardNumber());
    db.changeCardCVV(cardNumber, card2.getCvv());
    db.changeCardExpDate(cardNumber, card2.getExpirationDate());
    //db.changeStreetAddress(cardNumber, card2.getStreet());
    db.changeCityCounty(cardNumber, card2.getCity());
    db.changeStateRegion(cardNumber, card2.getState());
    db.changeZipCode(cardNumber, card2.getZip());

    System.out.println("Following changes made:");
    System.out.println("New Name on Card: " + card2.getNameOnCard());
    System.out.println("New Card Number: " + card2.getCardNumber());
    System.out.println("New CVV: " + card2.getCvv());
    System.out.println("New Card Expiration Date: " + card2.getExpirationDate());
    System.out.println("New Street Address: " + card2.getStreet());
    System.out.println("New City: " + card2.getCity());
    System.out.println("New State: " + card2.getState());
    System.out.println("New Zip: " + card2.getZip());

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
        System.out.println("This is the user ID: " + userId);

        //Get Card data
        PaymentCard[] storedPaymentCards = db.createCardObjects(userId);
        if (storedPaymentCards.length > 2) {
            model.addAttribute("card" + 3, storedPaymentCards[2]);
            long cardNumber = storedPaymentCards[2].getCardNumber();
        }

        return "editCardThree";

    }


//Submit the changes made to the profile.
@RequestMapping(value = "/editCardThree", method = RequestMethod.POST)
public Object editCardThreeSubmit(@ModelAttribute("editCardThree") PaymentCard card3, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    User currentUser = (User) session.getAttribute("currentUser");
    int userId = currentUser.getUserId();

    //get values from form for card 3.
    PaymentCard[] storedPaymentCards = db.createCardObjects(userId);
    model.addAttribute("card" + 3, storedPaymentCards[2]);
    long cardNumber = card3.getCardNumber();

    db.changeCardName(cardNumber, card3.getNameOnCard());
    db.changeCardNumber(cardNumber, card3.getCardNumber());
    db.changeCardCVV(cardNumber, card3.getCvv());
    db.changeCardExpDate(cardNumber, card3.getExpirationDate());
    //db.changeStreetAddress(cardNumber, card3.getStreet());
    db.changeCityCounty(cardNumber, card3.getCity());
    db.changeStateRegion(cardNumber, card3.getState());
    //db.changeZipCode(cardNumber, card3.getZip());

    System.out.println("Following changes made:");
    System.out.println("New Name on Card: " + card3.getNameOnCard());
    System.out.println("New Card Number: " + card3.getCardNumber());
    System.out.println("New CVV: " + card3.getCvv());
    System.out.println("New Card Expiration Date: " + card3.getExpirationDate());
    System.out.println("New Street Address: " + card3.getStreet());
    System.out.println("New City: " + card3.getCity());
    System.out.println("New State: " + card3.getState());
    System.out.println("New Zip: " + card3.getZip());

    return "loginSuccess";

    }
}

