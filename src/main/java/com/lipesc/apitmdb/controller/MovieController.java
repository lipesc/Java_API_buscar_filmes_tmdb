package com.lipesc.apitmdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lipesc.apitmdb.model.Movie;
import com.lipesc.apitmdb.model.MovieResponse;
import com.lipesc.apitmdb.service.MovieService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

   @GetMapping("/top")
    public Mono<MovieResponse> getTop10Movies() {
        return movieService.getTop10Movies();
    }

   @GetMapping("/search/{name}")
    public Mono<MovieResponse> searchMoviesByName(@PathVariable String name) {
        return movieService.searchMoviesByName(name);
    }
}
