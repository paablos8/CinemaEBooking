package com.example.CinemaEBooking.controller;

import java.io.UnsupportedEncodingException;

import javax.management.MBeanException;
import javax.print.DocFlavor.URL;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.CinemaEBooking.entities.Movie;
import com.example.Database.DatabaseConnector;


@Controller
public class AdminManageMovieController {

    DatabaseConnector db = new DatabaseConnector();
    
    @RequestMapping(value = "/adminManageMovies", method = RequestMethod.GET)
    public String showAdminManageMoviesPage(ModelMap model) {
        

        String titles[] = db.getAllTitles();
        int[] shows = db.getAllShowtimeIDs();
        String time = db.getShowTime(shows[0]);
        
        
        for (int i = 0; i < titles.length; i++) {
            String name = "movie" + i;
            String edit = "edit" + i;
            String remove = "remove" + i;
            String schedule = "schedule" + i;
            String title = titles[i];
            model.addAttribute(name, title);
            model.addAttribute(edit, "edit");
            model.addAttribute(remove, "remove");
            model.addAttribute(schedule, "schedule");
          }

          //System.out.println(show);
          System.out.println(time);

       
        return "adminManageMovies";
    }

//Method to get all the entered values when a 
}