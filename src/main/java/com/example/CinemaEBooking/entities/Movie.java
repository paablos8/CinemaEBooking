package com.example.CinemaEBooking.entities;

import java.net.URL;

public class Movie {
    private String movieTitle;
    private String category;
    private String cast;
    private String director;
    private String producer;
    private String synopsis;
    private int imdbRating;
    private int rtRating;
    private String trailerPicture;
    private String trailerVideo;
    private String filmRatingCode;
    private Show[] shows;
    

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


    public String getCast() {
        return cast;
    }


    public void setCast(String cast) {
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


    public int getImdbRating() {
        return imdbRating;
    }


    public void setImdbRating(int imdbRating) {
        this.imdbRating = imdbRating;
    }


    public int getRtRating() {
        return rtRating;
    }


    public void setRtRating(int rtRating) {
        this.rtRating = rtRating;
    } 


    public String getTrailerPicture() {
        return trailerPicture;
    }


    public void setTrailerPicture(String trailerPicture) {
        this.trailerPicture = trailerPicture;
    }


    public String getTrailerVideo() {
        return trailerVideo;
    }


    public void setTrailerVideo(String trailerVideo) {
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
