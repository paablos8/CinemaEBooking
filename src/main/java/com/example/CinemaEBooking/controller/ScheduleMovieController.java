package com.example.CinemaEBooking.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import com.example.Database.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CinemaEBooking.entities.Movie;
import com.example.CinemaEBooking.entities.Show;
import com.example.Database.DatabaseConnector;

@Controller
public class ScheduleMovieController {

    DatabaseConnector db = new DatabaseConnector();
    DateTime dt = new DateTime();


    @RequestMapping(value = "/scheduleMovie", method = RequestMethod.GET)
    public String scheduleMovie(ModelMap model, @RequestParam String movie) {
        model.addAttribute("scheduleMovieForm", new Show());
        model.addAttribute("title", movie);
        
        return "scheduleMovie";
    }

    @RequestMapping(value = "/scheduleMovie", method = RequestMethod.POST)
    public Object scheduleMovieSubmit(@ModelAttribute("scheduleMovieForm") Show show, Model model, HttpServletRequest request, @RequestParam String movie) {
        model.addAttribute("scheduleMovieForm", new Show());
        model.addAttribute("title", movie);
        LocalDateTime dateTime = dt.createDT(show.getYear(), show.getMonth(), show.getDay(), show.getHour(), show.getMinute());
        System.out.println(dt.toString(dateTime));
        System.out.println(db.createNewShowtime(movie, 1, dt.toString(dateTime)));
        
        return "scheduleMovie";
    }
}