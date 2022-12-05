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
public class EditCardOverview {

    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();    

    @RequestMapping(value = "/editCardOverview", method = RequestMethod.GET)
    public String showEditCardOverviewPage(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int userId = currentUser.getUserId();
    
    
        //get values from form for card 2.
        PaymentCard[] storedPaymentCards = db.createCardObjects(userId);

        if(storedPaymentCards.length == 1) {
            model.addAttribute("card1Created", "Already Card 1 implemented");
        }

        if(storedPaymentCards.length == 2) {
            model.addAttribute("card1Created", "Already Card 1 implemented");
            model.addAttribute("card2Created", "Already Card 2 implemented");
        }

        if(storedPaymentCards.length == 3) {
            model.addAttribute("card1Created", "Already Card 1 implemented");
            model.addAttribute("card2Created", "Already Card 2 implemented");
            model.addAttribute("card3Created", "Already Card 3 implemented");
        }

        return "editCardOverview";
    }   
    
}
