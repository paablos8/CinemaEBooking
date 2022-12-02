package com.example.CinemaEBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Database.DatabaseConnector;
import com.example.Database.DateTime;



@Controller
public class MovieDetailsController {
    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();
    DateTime dt = new DateTime();


    @RequestMapping(value = "/movieDetails", method = RequestMethod.GET)
    public String showMovieDetails(ModelMap model, @RequestParam String movie) {
        model.addAttribute("title", movie);
        model.addAttribute("image", db.getPosterURL(movie));
        model.addAttribute("trailer", db.getTrailerURL(movie));
        model.addAttribute("cast", db.getCast(movie));
        model.addAttribute("director", db.getProducer(movie));
        model.addAttribute("producer", db.getProducer(movie));
        model.addAttribute("reviews", db.getRTRating(movie));
        model.addAttribute("mpaa", db.getAgeRating(movie));
        model.addAttribute("synopsis", db.getSynopsis(movie));
        
        int[] showIDs = db.getAllShowtimeIDs();
        
        int j = 1;
        for (int i = 0; i < showIDs.length ; i++){
            if (db.getShowTitle(showIDs[i]).equals(movie)){
                
                String dateTime = "showtime" + j;
                String show = "show" + j;
                model.addAttribute(dateTime, db.getShowDateAndTime(showIDs[i]));
                model.addAttribute(show, i);
                j++;
            }
        }
        
        return "movieDetails";
    }

    


}
