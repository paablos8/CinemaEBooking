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

    //Searching by title
        String[] allTitles = db.getAllTitles();
        String matchingTitle = "";
        boolean matchFoundTitle = false;
        boolean matchFoundCategory = false;

        for (int i = 0; i < allTitles.length; i++) {
            //System.out.println(allTitles[i]);
            System.out.println(db.getCategory(allTitles[i]));
    
            
            if(search.equals(allTitles[i])) {
                matchingTitle = allTitles[i];
                matchFoundTitle = true;
                
            }
        }

        if (matchFoundTitle == true) {
                String name = "movie" + 0;
                String title = allTitles[0];
                model.addAttribute(name, title);
                model.addAttribute(name + "_img",db.getPosterURL(title));
                model.addAttribute(name + "_trailer",db.getTrailerURL(title));
                model.addAttribute(name + "_rating", db.getAgeRating(title));
        }

    
    //Searching by category
        String[] allTitlesInCategory = db.getTitlesInCategory(search);
        
        if(allTitlesInCategory.length != 0) {
                matchFoundCategory = true;
        }
        
        for (int i = 0; i < allTitlesInCategory.length; i++) {
            System.out.println(allTitlesInCategory[i]);       
            }

        

        if(matchFoundCategory == true) {

              for (int j = 0; j < allTitlesInCategory.length; j++) {
                String name = "movie" + j;
                String title = allTitlesInCategory[j];
                model.addAttribute(name, title);
                model.addAttribute(name + "_img",db.getPosterURL(title));
                model.addAttribute(name + "_trailer",db.getTrailerURL(title));
                model.addAttribute(name + "_rating", db.getAgeRating(title));
              }
        }

        if(matchFoundCategory || matchFoundTitle == true) {
            return "searchResults";
        }
        
        else {
            
            System.out.println("No movie found!");
            return "redirect:/searchError";
        }
    }
    
}

