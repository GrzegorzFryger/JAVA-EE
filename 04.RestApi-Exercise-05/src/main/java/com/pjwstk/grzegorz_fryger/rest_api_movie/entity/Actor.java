package com.pjwstk.grzegorz_fryger.rest_api_movie.entity;

import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.interfaces.JsonBindingInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Actor extends Person implements Serializable, JsonBindingInterface
{

    private List<String> movie;

    public Actor()
    {
        super();
        this.movie = new ArrayList<>();

    }


    public List<String> getMovie() {
        return movie;
    }

    public void setMovie(List<String> movie) {
        this.movie = movie;
    }


}
