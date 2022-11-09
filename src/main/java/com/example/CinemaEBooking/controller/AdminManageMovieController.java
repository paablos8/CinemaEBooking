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
        model.addAttribute("movieForm", new Movie());
        return "adminManageMovies";
    }

    @RequestMapping(value = "/adminManageMovies", method = RequestMethod.POST)
    public Object addMovies(@ModelAttribute("movieForm") Movie movieForm, BindingResult bindingResult,
                                  Model model, HttpServletRequest request) throws UnsupportedEncodingException, MBeanException {

                                    String movieTitle = movieForm.getMovieTitle();
                                    String category = movieForm.getCategory();
                                    //String cast = movieForm.getCast();
                                    String director = movieForm.getDirector();
                                    String producer = movieForm.getProducer();
                                    String synopsis = movieForm.getSynopsis();
                                    //String reviews = movieForm.getReviews();
                                    String trailerPicture = movieForm.getTrailerPicture();
                                    String trailerVideo = movieForm.getTrailerVideo();
                                    String filmRatingCode = movieForm.getFilmRatingCode();
                                //input field is currently still a String
                                    //Show[] shows = getShows();

        db.createNewMovie(movieTitle, filmRatingCode, 0, producer, director, "tbd", 0,0, trailerVideo, trailerPicture, category, synopsis, 120);

        System.out.println("Movie created with title:" + movieTitle);

        return "redirect:/adminManageMovies";
    }
}