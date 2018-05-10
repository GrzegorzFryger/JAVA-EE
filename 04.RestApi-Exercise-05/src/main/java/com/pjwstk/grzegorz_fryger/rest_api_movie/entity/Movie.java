package com.pjwstk.grzegorz_fryger.rest_api_movie.entity;


import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.interfaces.JsonBindingInterface;

import java.io.Serializable;
import java.util.*;


public class Movie implements Serializable, JsonBindingInterface {


    private Long id;
    private String title;
    private int yearOfRealised;
    private String description;
    private com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Director director;
    private com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Rating rating;
    //private float rating;
  //  private int numberOfRating;

    private List<com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Genres> genres;


    private List<com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Comment> commentList;

    private List<String> actorList;


    public Movie() {

        this.commentList = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfRealised() {
        return yearOfRealised;
    }

    public void setYearOfRealised(int yearOfRealised) {
        this.yearOfRealised = yearOfRealised;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Director getDirector() {
        return director;
    }


    public void setDirector(com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Director director) {
        this.director = director;
    }

    public com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Rating getRating() {
        return rating;
    }

    public void setRating(com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Rating rating) {
        this.rating = rating;
    }

    public List<com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Genres> genres) {
        this.genres = genres;
    }

    public List<String> getActorList() {
        return actorList;
    }

    public void setActorList(List<String> actorList) {
        this.actorList = actorList;
    }

    public List<com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearOfRealised=" + yearOfRealised +
                ", description='" + description + '\'' +
                ", director=" + director +
                ", rating=" + rating +
                ", genres=" + genres +
                ", commentList=" + commentList +
                ", actorList=" + actorList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getYearOfRealised() == movie.getYearOfRealised() &&
                Objects.equals(getId(), movie.getId()) &&
                Objects.equals(getTitle(), movie.getTitle()) &&
                Objects.equals(getDescription(), movie.getDescription()) &&
                Objects.equals(getDirector(), movie.getDirector()) &&
                Objects.equals(getRating(), movie.getRating()) &&
                Objects.equals(getGenres(), movie.getGenres()) &&
                Objects.equals(getCommentList(), movie.getCommentList()) &&
                Objects.equals(getActorList(), movie.getActorList());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getTitle(), getYearOfRealised(), getDescription(), getDirector(), getRating(), getGenres(), getCommentList(), getActorList());
    }
}
