package com.example.CinemaEBooking.controller;


import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.CinemaEBooking.entities.Movie;
import com.example.CinemaEBooking.entities.User;
import com.example.Database.DatabaseConnector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

@Controller
public class OrderHistoryController {
    DatabaseConnector db = DatabaseConnector.getInstance();
    
    @RequestMapping(value = "/orderHistory", method = RequestMethod.GET)
    public String showOrderHistory(ModelMap model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        int [] orders = db.getBookings(currentUser.getUserId());
        for (int i = 0; i < orders.length; i++) {
            String name = "movie" + i;
            String child = "child" + i;
            String adult = "adult" + i;
            String senior = "senior" + i;
            String total = "total" + i;

            

            int showID = db.getShowtimeID(orders[i]);
            String title = db.getShowTitle(showID);
            String numChild = "Child tickets: " + db.getChildTickets(orders[i]);
            String numAdult = "Adult tickets: " + db.getAdultTickets(orders[i]);
            String numSenior = "Senior tickets: " + db.getSeniorTickets(orders[i]);
            String totalPrice =  "Total: $" + db.getTotal(orders[i]);

           
            model.addAttribute(name, title);
            model.addAttribute(child, numChild);
            model.addAttribute(adult, numAdult);
            model.addAttribute(senior, numSenior);
            model.addAttribute(total, totalPrice);
          }

       


       
        return "orderHistory";
    }
}
