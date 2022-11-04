package com.example.CinemaEBooking.entities;

import java.net.URL;

public class Movie {
    private String movieTitle;
    private String category;
    private String[] cast;
    private String director;
    private String producer;
    private String synopsis;
    private String[] reviews;
    private URL trailerPicture;
    private URL trailerVideo;
    private String filmRatingCode;
    private Show[] shows;
    

    //constructor
    public Movie(String movieTitle) {
        this.movieTitle = movieTitle;
    }


    public String getMovieTitle() {
        return movieTitle;
    }


    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String[] getCast() {
        return cast;
    }


    public void setCast(String[] cast) {
        this.cast = cast;
    }


    public String getDirector() {
        return director;
    }


    public void setDirector(String director) {
        this.director = director;
    }


    public String getProducer() {
        return producer;
    }


    public void setProducer(String producer) {
        this.producer = producer;
    }


    public String getSynopsis() {
        return synopsis;
    }


    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }


    public String[] getReviews() {
        return reviews;
    }


    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }


    public URL getTrailerPicture() {
        return trailerPicture;
    }


    public void setTrailerPicture(URL trailerPicture) {
        this.trailerPicture = trailerPicture;
    }


    public URL getTrailerVideo() {
        return trailerVideo;
    }


    public void setTrailerVideo(URL trailerVideo) {
        this.trailerVideo = trailerVideo;
    }


    public String getFilmRatingCode() {
        return filmRatingCode;
    }


    public void setFilmRatingCode(String filmRatingCode) {
        this.filmRatingCode = filmRatingCode;
    }


    public Show[] getShows() {
        return shows;
    }


    public void setShows(Show[] shows) {
        this.shows = shows;
    }
     
}
