package com.example.movieviewservice.model;

public class Movie {
    public String movieId;
    public String name;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }
}
