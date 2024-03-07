package com.Blogger2;

import java.util.Comparator;

public class MovieYear implements Comparator<Movie> {
    private String name;

    private int rating;

    private int year;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getYear()-o2.getYear();
    }
}
