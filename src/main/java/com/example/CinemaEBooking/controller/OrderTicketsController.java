package com.example.CinemaEBooking.controller;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.example.CinemaEBooking.entities.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Database.DatabaseConnector;

@Controller
public class OrderTicketsController {

    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();

    @RequestMapping(value = "/orderTickets",method = RequestMethod.GET )
    public String orderTicks(ModelMap model, @RequestParam int show, HttpServletRequest request){
        
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        

        if (currentUser == null){
            return "redirect:/userLogin";
        }
        String movie = db.getShowTitle(show);
        model.addAttribute("title", movie);
        model.addAttribute("img", db.getPosterURL(movie));

        return "orderTickets";
    }
}
