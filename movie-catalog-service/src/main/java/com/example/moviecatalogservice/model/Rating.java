package com.example.moviecatalogservice.model;

public class Rating {
    public Rating() {
    }

    public String movieId;
    public Integer rating;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Rating(String movieId, Integer rating) {
        this.movieId = movieId;
        this.rating = rating;
    }
}
