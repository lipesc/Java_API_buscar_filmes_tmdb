package com.lipesc.apitmdb.model;

import lombok.Data;

@Data
public class Movie {
    private String title;
    private String original_title;
    private String overview;
    private String release_date;
    private String poster_path;
    private double vote_average;
}

