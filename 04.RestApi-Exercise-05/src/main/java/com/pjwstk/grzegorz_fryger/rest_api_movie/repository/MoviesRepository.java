package com.pjwstk.grzegorz_fryger.rest_api_movie.repository;


import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Actor;
import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Comment;
import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Movie;
import com.pjwstk.grzegorz_fryger.rest_api_movie.service.IdentifiableImpl;
import com.pjwstk.grzegorz_fryger.rest_api_movie.service.MovieData;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Singleton
public class MoviesRepository {


    @Inject
    private IdentifiableImpl identifiableForMovie;

    @Inject
    private IdentifiableImpl identifiableForDirector ;

    @Inject
    private IdentifiableImpl identifiableForComment ;





    private Map<Long, Movie> movieMap = new TreeMap<>();


    public Map<Long, Movie> getMovieMap() {
        return movieMap;
    }


    public void setMovieMap(Map<Long, Movie> movieMap) {
        this.movieMap = movieMap;
    }

    public List<Movie> getAll() {
        List<Movie> movies = null;




        try {

            movies = movieMap.values().stream().collect(Collectors.toList());
        } catch (NullPointerException e) {
            throw new RuntimeException("Empty List",e);
        }

        return movies;

    }

    public Movie getMovieById(Long id) {


        Movie movie = null;

        try {
            movie = movieMap.get(id);
        } catch (NullPointerException e) {
            throw new RuntimeException("List doesn't have movie containing that id ",e);
        }

        return movie;
    }

    public Long addMovie(Movie movie) {



        try {

            movie.getCommentList().forEach( a -> a.setId(identifiableForComment.generateId()));
            movie.getDirector().setId(identifiableForDirector.generateId());
            movie.setId(identifiableForMovie.generateId());
            movieMap.put(movie.getId(), movie);

        } catch (NullPointerException e) {
            throw new RuntimeException("Empty Movie " + identifiableForMovie.getCurrentId(),e);
        }

        return identifiableForMovie.getCurrentId();

    }

    public void updateMovie(Long id, Movie movie) {


        try {
            movieMap.put(id, movie);

        } catch (NullPointerException e) {
            throw new RuntimeException("Map doesen't contain that object",e);

        }
    }

    public List<Comment> getCommentMovie(Long id) {


        List<Comment> comments = null;


        try {
            comments = movieMap.get(id).getCommentList();
        } catch (NullPointerException e) {
            throw new RuntimeException("Movie doesen't contains comments ",e);
        }

        return comments;
    }

    public void deleteComment(Long idMovie, Long idComment) {


        try {

            movieMap.get(idMovie).getCommentList().remove(idComment.intValue() - 1);

        } catch (NullPointerException e) {
            throw new RuntimeException("Not contains elements ",e);
        }

    }

    public Long addCommentToMovie(Long id,Comment comment)
    {



        Long generatedId = identifiableForComment.generateId();
        comment.setId(generatedId);
        try {

            movieMap.get(id).getCommentList().add(comment);
        }
        catch (NullPointerException e)
        {


            throw new RuntimeException("Not contains elements ",e);
        }

        return generatedId;
    }


    public void addRating(Long id, float rating) {


        try {


           movieMap.get(id).getRating().addRate(rating);


        } catch (NullPointerException e) {
            throw new RuntimeException("Null rating ",e);
        }

    }

    public List<String> getActorsMovie(Long id)
    {
        List<String> temp = null;
        try {

            temp = movieMap.get(id).getActorList();

        }catch (RuntimeException e){
            throw new RuntimeException("Not add");
        }
        return temp;
    }

    public void addActorToMovie(Long id,Actor actor)
    {
        try{

            movieMap.get(id).getActorList().add(actor.getFirstName() + " " + actor.getLastName());
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException("Not add actor");
        }

    }



}
