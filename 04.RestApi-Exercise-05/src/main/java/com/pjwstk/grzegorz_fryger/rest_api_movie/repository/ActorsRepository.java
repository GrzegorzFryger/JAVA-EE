package com.pjwstk.grzegorz_fryger.rest_api_movie.repository;

import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Actor;
import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Movie;
import com.pjwstk.grzegorz_fryger.rest_api_movie.service.interfaces.Identifiable;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Singleton
public class ActorsRepository
{

    @Inject
    Identifiable identifiableForActor;


   private Map<Long,Actor> actorMap = new TreeMap<>();

    public Map<Long, Actor> getActorMap() {
        return actorMap;
    }

    public void setActorMap(Map<Long, Actor> actorMap) {
        this.actorMap = actorMap;
    }

    public List<String> getMovieFromActor(Long id)
    {
        List <String> temp = null;


        try {
             temp = actorMap.get(id).getMovie();
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException("Not found");
        }

        return temp;
    }

    public void addActor(Actor actor)
    {
        Long id = identifiableForActor.generateId();
        actor.setId(id);

        try{

            actorMap.put(id,actor);


        }
        catch (RuntimeException e)
        {
            throw new RuntimeException(e.toString());
        }


    }

    public void addMovieToActor(Long id, Movie movie)
    {

        try {

            actorMap.get(id).getMovie().add(movie.getTitle());
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException("Not add");
        }
    }


}
