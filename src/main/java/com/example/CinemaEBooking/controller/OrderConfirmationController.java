package com.example.CinemaEBooking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.CinemaEBooking.entities.User;
import com.example.Database.DatabaseConnector;

@Controller
@SessionAttributes("currentUser")
public class OrderConfirmationController {

    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();


    //Send confirmation Email
    @Autowired
    JavaMailSender javaMailSender;

    void sendConfirmationEmail(String email, long cardNumber, String promoCode, double total, int adultTickets, int seniorTickets, int childTickets, double moneySaved, String title, String showtime) {

        SimpleMailMessage msg = new SimpleMailMessage();        
            msg.setTo(email);
            msg.setSubject("MovieHub - Order Confirmation");
            msg.setText("Thank you for your recent purchase! You just bought " + adultTickets + " Adult Tickets, " + childTickets + " Child Tickets, " + seniorTickets + " Senior Tickets for the Movie "+ title + " on " + showtime + " for a total of $" + total + " !");
        
            javaMailSender.send(msg);
    }

    @RequestMapping(value = "/orderSummary", method = RequestMethod.GET)
    public String showOrderSummaryPage(ModelMap model, HttpServletRequest request) {

        //Get current logged in user
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int userId = currentUser.getUserId();

        String email = db.getUserEmail(userId);
        
        int[] allBookings = db.getBookings(userId);


        int highestIndex = allBookings.length; 
        System.out.println(highestIndex);

        int bookingId = allBookings[highestIndex-1];

        System.out.println("This is the highest bookingID" + bookingId);
        
        long cardNumber = db.getCardNum (bookingId);
        String promoCode = db.getPromoCode(bookingId);
        double total = db.getTotal(bookingId);
        int showtimeId = db.getShowtimeID(bookingId);
        int adultTickets = db.getAdultTickets(bookingId);
        int childTickets = db.getChildTickets(bookingId);
        int seniorTickets = db.getSeniorTickets(bookingId);

        double percentOff = db.getPercentOff(promoCode)/100;
        double moneySaved = percentOff * total;
        String title = db.getShowTitle(showtimeId);
        String showtime = db.getShowDateAndTime(showtimeId);        

        model.addAttribute("cardNumber", cardNumber);
        model.addAttribute("promoCode", promoCode);
        model.addAttribute("total", total);
        model.addAttribute("showtimeId", showtimeId);
        model.addAttribute("adultTickets", adultTickets);
        model.addAttribute("childTickets", childTickets);
        model.addAttribute("seniorTickets", seniorTickets);
        model.addAttribute("moneySaved", moneySaved);  
        model.addAttribute("title", title); 
        model.addAttribute("showtime", showtime); 
        
        sendConfirmationEmail(email, cardNumber, promoCode, total, adultTickets, seniorTickets, childTickets, moneySaved, title, showtime);
        
        
        
        return "orderSummary";
    }   

    
}
    

