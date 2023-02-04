package com.example.moviecatalogservice.controller;

import com.example.moviecatalogservice.model.CatalogItem;
import com.example.moviecatalogservice.model.Movie;
import com.example.moviecatalogservice.model.Rating;
import com.example.moviecatalogservice.model.UserRating;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){



        UserRating ratings = restTemplate.getForObject("http://movie-rating-service/ratingsdata/users/"+userId, UserRating.class);

        return  ratings.getUserRating().stream().map( rating -> {
            Movie movie = restTemplate.getForObject("http://movie-view-service/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(),"desc", rating.getRating());
        }).collect(Collectors.toList());
//        return Collections.singletonList(
//                new CatalogItem("Jason Bourne", "Test", 7)
//        );
    }
}
