package com.example.movieratingservice.controller;

import com.example.movieratingservice.model.Rating;
import com.example.movieratingservice.model.UserRating;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId")  String movieId){
        return new Rating(movieId, 8);
    }

    @RequestMapping("/users/{userId}")
    public UserRating  getUserRating(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 7)
        );
        UserRating userRating = new UserRating(ratings);
        return userRating;
    }

}
