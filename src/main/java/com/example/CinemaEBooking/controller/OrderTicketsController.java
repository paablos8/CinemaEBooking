package com.example.CinemaEBooking.controller;
import org.springframework.ui.ModelMap;
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
    public String orderTicks(ModelMap model, @RequestParam String movie){
        model.addAttribute("title", movie);
        model.addAttribute("img", db.getPosterURL(movie));

        return "orderTickets";
    }
}
