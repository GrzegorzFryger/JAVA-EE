package com.pjwstk.grzegorz_fryger.rest_api_movie.service;


import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.*;

import java.util.*;

import static java.util.Arrays.asList;



public class MovieData
{
  public static  Map<Long, Movie> getData()
  {

      //CalculatingAverageGrade r =  new CalculatingAverageGrade();
    //  r.addRating(8);

     Comment comment = new Comment();

      comment.setComment("asdsadds");
      comment.setDate(1998);
      comment.setName("grzegorz");
      comment.setTitle("test kometarza");

      Comment comment2 = new Comment();
      comment2.setComment("asdsadds");
      comment2.setDate(1997);
      comment2.setName("grzegorz");
      comment2.setTitle("test kometarza");

      List<String> actorMap =  new ArrayList<>();
      actorMap.add(getActor().getFirstName()+" " + getActor().getLastName());
      actorMap.add(getActor().getFirstName()+" " + getActor().getLastName());

     List<Comment> commentMap = new ArrayList<>();
      commentMap.add(comment);
      commentMap.add(comment2);


      Map<Long,Movie> temp = new TreeMap<>();

      Movie movie = new Movie();

      movie.setId(Long.valueOf(1));
      movie.setTitle("drugi");
      movie.setYearOfRealised(2018);
      movie.setDescription("film testowy");
        movie.setDirector(getDirector());
     // movie.setRating(Float.valueOf(6));
     // movie.setRating(Float.valueOf(6));
      movie.setGenres(asList(Genres.ACTION,Genres.ADVENTURE));
      movie.setActorList(actorMap);
     movie.setCommentList(commentMap);
     Movie movie1 = new Movie();
     movie1.setTitle("drugi");

      temp.put(Long.valueOf(1),movie);

      //temp.put(Long.valueOf(2),movie1);


      return temp;
  }

  public static Director getDirector()
  {
      Director dir = new Director();
     // dir.setId(1);
      dir.setFirstName("Dyrektor1");
      dir.setLastName("Drektor1-surname");
      dir.setDateOfBirth(1995);
      dir.setPlaceOfBirth("gdansk");
      dir.setBiography("Produkcja pierwszego filmu");
      dir.setMovies(asList("Pierwszy film","drugi film","trzeci film"));
      return dir;
  }

  public static Actor getActor()
  {
    Actor actor = new Actor();
      actor.setId(Long.valueOf(1));
      actor.setFirstName("Aktor1");
      actor.setLastName("Aktor-surname");
      actor.setDateOfBirth(2005);
      actor.setPlaceOfBirth("gdansk");
      actor.setBiography("Produkcja pierwszego filmu");
      actor.setMovie(asList("Pierwszy film","drugi film","trzeci film"));

      return actor;
  }
}
