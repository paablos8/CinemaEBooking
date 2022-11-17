package com.example.CinemaEBooking.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Database.DatabaseConnector;


@Controller
public class SearchBarController {
    DatabaseConnector db = new DatabaseConnector();


    @RequestMapping(value = "/searchResults", method = RequestMethod.GET)
    public String showSearchResults (ModelMap model, @RequestParam (value = "search") String search) {

        String[] allTitles = db.getAllTitles();
        String matchingTitle = "";
        boolean matchFound = false;


        for (int i = 0; i < allTitles.length; i++) {
            System.out.println(allTitles[i]);
            System.out.println(search);
            if(search.equals(allTitles[i])) {
                matchingTitle = allTitles[i];
                matchFound = true;
                
            }
            System.out.println(matchFound);
        }

        if(matchFound == true) {
  
            String name = "movie";
                
            model.addAttribute(name, matchingTitle);
            model.addAttribute(name + "_img",db.getPosterURL(matchingTitle));
            model.addAttribute(name + "_trailer",db.getTrailerURL(matchingTitle));

            return "searchResults";
        }
        

        else {
            
            System.out.println("No movie found!");
            return "redirect:/homePage";
        }
    }
}
