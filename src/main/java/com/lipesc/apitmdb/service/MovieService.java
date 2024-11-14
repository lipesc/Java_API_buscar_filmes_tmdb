package com.lipesc.apitmdb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.lipesc.apitmdb.model.MovieResponse;

import reactor.core.publisher.Mono;

@Service
public class MovieService {
  private WebClient webClient;
  private String apiToken;


  public MovieService(WebClient.Builder webClientBuilder,@Value("${tmdb.api.token}") String apiToken) {
    this.webClient = webClientBuilder.baseUrl("https://api.themoviedb.org/3").build();
    this.apiToken = apiToken;
  }


 public Mono<MovieResponse> searchMoviesByName(String name) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/search/movie")
                .queryParam("query", name)
                .queryParam("include_adult", false)
                .queryParam("language", "pt-BR")
                .queryParam("page", 1)
                .build())
            .headers(headers -> headers.setBearerAuth(apiToken))
            .retrieve()
            .bodyToMono(MovieResponse.class);
    }


     public Mono<MovieResponse> getTop10Movies(int page) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/movie/popular")
                .queryParam("language", "pt-BR")
                .queryParam("page", page)
                .build())
            .headers(headers -> headers.setBearerAuth(apiToken))
            .retrieve()
            .bodyToMono(MovieResponse.class);
    }
}
