package com.example.CinemaEBooking.controller;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Database.DatabaseConnector;
import com.example.CinemaEBooking.entities.Movie;
import com.example.CinemaEBooking.entities.Ticket;

@Controller
public class HomepageController {

    private DatabaseConnector db = new DatabaseConnector();
    
    @RequestMapping("/")
    public String home(){
        return "redirect:/homePage";
    }

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public String homePage (ModelMap model){
        String titles[] = db.getAllTitles();

        for (int i = 0; i < titles.length && i < 5; i++) {
            String name = "active" + i;
            String title = titles[i];
            model.addAttribute(name, title);
            model.addAttribute(name + "_img",db.getPosterURL(title));
            model.addAttribute(name + "_trailer",db.getTrailerURL(title));
          }

          for (int i = 5; i < titles.length && i < 10; i++) {
            int j = i - 5;
            String name = "coming" + j;
            String title = titles[i];
            model.addAttribute(name, title);
            model.addAttribute(name + "_img",db.getPosterURL(title));
            model.addAttribute(name + "_trailer",db.getTrailerURL(title));
          }
        
        

        return "homePage";
    }

    @RequestMapping("/registrationConfirmation")
    public String registrationConfirmation(){

        return "registrationConfirmation";
    }

    @RequestMapping("/orderTicketsFightClub")
    public String orderTicks(){

        return "orderTicketsFightClub";
    }
}