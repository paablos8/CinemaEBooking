package com.example.CinemaEBooking.controller;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Database.DatabaseConnector;
import com.example.CinemaEBooking.entities.Movie;

@Controller
public class HomepageController {

    private DatabaseConnector db = new DatabaseConnector();
    
    @RequestMapping("/")
    public String home(){
        return "redirect:/homePage";
    }

    @RequestMapping("/homePage")
    public String homePage (ModelMap model){
        
        String titles[] = db.getAllTitles();
        
        
    

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