package com.example.CinemaEBooking.controller;

import java.io.UnsupportedEncodingException;

import javax.management.MBeanException;
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
public class AddMovieController {

    private DatabaseConnector db = new DatabaseConnector();

    

    @RequestMapping(value = "/addMovie", method = RequestMethod.GET)
    public String showAddMoviePage(Model model) {
    model.addAttribute("addMovieForm", new Movie());
        return "addMovie";
    }


//Add new Movie
@RequestMapping(value = "/addMovie", method = RequestMethod.POST)
public Object addMovie (@ModelAttribute("addMovieForm") Movie addMovieForm, BindingResult bindingResult,
Model model, HttpServletRequest request) throws UnsupportedEncodingException, MBeanException {

                                    String movieTitle = addMovieForm.getMovieTitle();
                                    String category = addMovieForm.getCategory();
                                    String cast = addMovieForm.getCast();
                                    String director = addMovieForm.getDirector();
                                    String producer = addMovieForm.getProducer();
                                    String synopsis = addMovieForm.getSynopsis();
                                    int imdbRating = addMovieForm.getImdbRating();
                                    int rtRating = addMovieForm.getRtRating();
                                    String trailerPicture = addMovieForm.getTrailerPicture();
                                    String trailerVideo = addMovieForm.getTrailerVideo();
                                    String filmRatingCode = addMovieForm.getFilmRatingCode();
                                //input field is currently still a String
                                    //Show[] shows = getShows();

        System.out.println(db.createNewMovie(movieTitle, filmRatingCode, 0, producer, director, cast, imdbRating, rtRating, trailerVideo, trailerPicture, category, synopsis, 120));

        System.out.println("Movie created with title:" + movieTitle);



    return "redirect:/adminManageMovies";
}
    
}
