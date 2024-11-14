package com.lipesc.apitmdb.model;

import lombok.Data;
import java.util.List;

@Data
public class MovieResponse {
    private int page;
    private int total_pages;
    private int total_results;
    private List<Movie> results;
}

