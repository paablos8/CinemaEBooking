package com.example.CinemaEBooking.controller;
import org.springframework.ui.ModelMap;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Database.DatabaseConnector;
import com.example.CinemaEBooking.entities.Movie;
import com.example.CinemaEBooking.entities.Ticket;

@Controller
public class HomepageController {

    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();
    
    @RequestMapping("/")
    public String home(){
        return "redirect:/homePage";
    }

    

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public String homePage (ModelMap model){
        String titles[] = db.getAllTitles();
        int showsId[] = db.getAllShowtimeIDs();
        String ShowsTitles[] = new String[100];
        int a = 0;
        int c = 0;

        for (int i = 0; i < showsId.length; i++){
            ShowsTitles[i] = db.getShowTitle(showsId[i]);
        }

        for (int j = 0; j < titles.length; j++){
            if (Arrays.asList(ShowsTitles).contains(titles[j])){
                String name = "active" + a;
                String title = titles[j];
                model.addAttribute(name, title);
                model.addAttribute(name + "_img",db.getPosterURL(title));
                model.addAttribute(name + "_trailer",db.getTrailerURL(title));
                a++;
            } else{
                String name = "coming" + c;
                String title = titles[j];
                model.addAttribute(name, title);
                model.addAttribute(name + "_img",db.getPosterURL(title));
                model.addAttribute(name + "_trailer",db.getTrailerURL(title));
                c++;
            }

        }

        return "homePage";
    }

    @RequestMapping("/registrationConfirmation")
    public String registrationConfirmation(){

        return "registrationConfirmation";
    }


    @RequestMapping("/viewCartBS")
    public String viewCartBS(){
        return "viewCartBS";
    }
}