package com.pjwstk.grzegorz_fryger.rest_api_movie.entity;

import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.interfaces.JsonBindingInterface;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable, JsonBindingInterface
{

    private Long id;

    private int date;

    private String name;

    private String title;

    private String comment;

    public Comment() {
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
