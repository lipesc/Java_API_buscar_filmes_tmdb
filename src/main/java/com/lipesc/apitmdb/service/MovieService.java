package com.lipesc.apitmdb.service;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.lipesc.apitmdb.model.MovieResponse;

import reactor.core.publisher.Mono;

@Service
public class MovieService {

    @Value("${tmdb.api.token:}")
    private String apiToken;

    private final WebClient webClient;



  public MovieService(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://api.themoviedb.org/3").build();
 
    }

        @PostConstruct
        public void validateToken() {
                if (apiToken == null || apiToken.isBlank()) {
                        throw new IllegalStateException("TMDB token not configured. Set env var TOKENTM or property tmdb.api.token.");
                }
        }


 public Mono<MovieResponse> searchMoviesByName(String name) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/search/movie")
                .queryParam("query", name)
                .queryParam("include_adult", true)
                .queryParam("language", "pt-BR")
                .queryParam("page", 1)
                .build())
            .header("Authorization", "Bearer " + apiToken)
            .retrieve()
            .bodyToMono(MovieResponse.class);
    }


     public Mono<MovieResponse> getTop10Movies(int page) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/discover/movie")
                .queryParam("language", "pt-BR")
                .queryParam("page", page)
                .build())
            .header("Authorization", "Bearer " + apiToken)
            .retrieve()
            .bodyToMono(MovieResponse.class);
    }
}
