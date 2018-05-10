package com.pjwstk.grzegorz_fryger.rest_api_movie.entity;

import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.interfaces.JsonBindingInterface;

import javax.json.bind.annotation.JsonbNumberFormat;

public class Rating implements JsonBindingInterface
{
    @JsonbNumberFormat("#.0")
    private float rate;
    private int numberOfRating;

    public float getRate() {
        return rate/numberOfRating;
    }

    public void setRate(float rating) {


        this.rate = rating;
    }

    public int getNumberOfRating() {
        return numberOfRating;
    }

    public void setNumberOfRating(int numberOfRating) {
        this.numberOfRating = this.numberOfRating + numberOfRating;
    }

    public void addRate(float rate)
    {
        this.numberOfRating = numberOfRating +1;
        this.rate = this.rate + rate;

    }

    @Override
    public String toString() {
        return "Rating{" +
                "rating=" + rate +
                ", numberOfRating=" + numberOfRating +
                '}';
    }
}
