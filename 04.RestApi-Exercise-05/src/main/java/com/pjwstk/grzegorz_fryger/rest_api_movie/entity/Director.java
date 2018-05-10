package com.pjwstk.grzegorz_fryger.rest_api_movie.entity;

import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.interfaces.JsonBindingInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Director extends Person implements Serializable, JsonBindingInterface
{

    private List<String> movies;

    public Director()
    {
        super();
        this.movies = new ArrayList<>();
    }

    public List<String> getMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }


}
