package com.lipesc.apitmdb.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lipesc.apitmdb.model.MovieResponse;
import com.lipesc.apitmdb.service.MovieService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
@CrossOrigin("/**")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/top/{page}")
    public Mono<MovieResponse> getTop10Movies(@PathVariable int page) {
        return movieService.getTop10Movies(page);
    }

    @GetMapping("/search/{name}")
    public Mono<MovieResponse> searchMoviesByName(@PathVariable String name) {
        return movieService.searchMoviesByName(name);
    }
}
