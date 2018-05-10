package com.pjwstk.grzegorz_fryger.rest_api_movie.boundary;

import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Actor;
import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Comment;
import com.pjwstk.grzegorz_fryger.rest_api_movie.entity.Movie;
import com.pjwstk.grzegorz_fryger.rest_api_movie.repository.ActorsRepository;
import com.pjwstk.grzegorz_fryger.rest_api_movie.repository.MoviesRepository;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.stream.Collectors;


@Path("movieresources")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource {


    @Inject
    MoviesRepository movieRepository;

    @Inject
    ActorsRepository actorsRepository;


    @Context
    UriInfo uriInfo;


    @GET
    @Path("/movies")
    public Response getMovies() {


      //  return Response.ok(Response.Status.OK).build();

       if (!movieRepository.getAll().isEmpty()) {
           return Response.ok(movieRepository.getAll()).build();
       }

        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @GET
    @Path("movie/{id}")
    public Response getMovie(@PathParam("id") @Min(0) Long id) {


        if (!movieRepository.getMovieById(id).equals(null)) {
            return Response.ok(movieRepository.getMovieById(id)).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @GET
    @Path("{id}/comments")
    public Response getCommentsMovie(@PathParam("id") @Min(0) Long id) {

        if (!movieRepository.getCommentMovie(id).isEmpty()) {
            return Response.ok(movieRepository.getCommentMovie(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}/comment/{id_c}")
    public Response deleteCommentFromMovie(@PathParam("id") @Min(0) Long id, @PathParam("id_c") @Min(0) Long id_c) {


        movieRepository.deleteComment(id, id_c);




        return Response.status(Response.Status.OK).build();


    }


    @POST
    @Path("/add/comment/movie/{id}")
    public Response addCommentToMovie(@PathParam("id") Long id, @Valid @NotNull Comment comment) {
        //


        Long reciveId = movieRepository.addCommentToMovie(id, comment);

        URI uri = uriInfo.getBaseUriBuilder()
                .path(MovieResource.class)
                .path("/")
                .path(MovieResource.class, "getCommentsMovie").build(id);


        return Response.created(uri).build();


    }


    @POST
    @Path("/add/movie")
    public Response addMovie(@Valid @NotNull Movie movie) {

        Long id = movieRepository.addMovie(movie);


        URI uri = uriInfo.getBaseUriBuilder()
                .path(MovieResource.class)
                .path("/")
                .path(MovieResource.class, "getMovie").build(id);

        return Response.created(uri).build();

    }

    @PUT
    @Path("/update/movie/{id}")
    public Response updateMovie(@PathParam("id") @Min(0) Long id, @Valid @NotNull Movie movie) {
        boolean hasMovie = movieRepository.getMovieById(id) != null;

        URI uri = null;


        if (hasMovie) {

            movieRepository.updateMovie(id, movie);
            uriInfo.getBaseUriBuilder()
                    .path(MovieResource.class)
                    .path("/")
                    .path(MovieResource.class, "getMovie").build(id);

            return Response.created(uri).status(Response.Status.ACCEPTED).build();

        }


        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @POST
    @Path("/add/rating/movie/{id}")
    public Response addRatingToMovie(@PathParam("id") @Min(0) Long id, JsonObject object) {
        String rate = null;
        try {

            rate = object.getString("rate");

        } catch (RuntimeException e) {
            throw new RuntimeException("Not correct value");
        }

        movieRepository.addRating(id, Float.valueOf(rate));


        return Response.ok().build();
    }

    @POST
    @Path("/add/actor")
    public Response addActor(@Valid @NotNull Actor actor)
    {
        actorsRepository.addActor(actor);

        return Response.ok(Response.Status.OK).build();
    }

    @GET
    @Path("/actors/movie/{id}")
    public Response getActorMovie(@PathParam("id") @Min(0) Long id)
    {
        if (!movieRepository.getActorsMovie(id).isEmpty()) {
            return Response.ok(movieRepository.getActorsMovie(id)).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/movies/actor/{id}")
    public Response getMoviesActor(@PathParam("id") @Min(0) Long id)
    {



        if (!actorsRepository.getMovieFromActor(id).isEmpty()) {
            return Response.ok(actorsRepository.getMovieFromActor(id)).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("/add/movie/actor/{id}")
    public Response addMovieToActor(@PathParam("id") @Min(0) Long id,JsonObject object)
    {
        if(object.keySet().contains("name") )
        {
            String titleMovie = object.getString("name");

           Movie movie1 = movieRepository.getAll().stream().filter(movie -> movie.getTitle().equals(titleMovie)).collect(
                    Collectors.collectingAndThen(
                            Collectors.toList(),list -> {
                                if (list.size() != 1) {
                                    throw new RuntimeException();
                                }return list.get(0);
                            }
                    )
            );

            actorsRepository.addMovieToActor(id,movie1);

            return Response.ok(Response.Status.ACCEPTED).build();
        }

        if (object.keySet().contains("id"))
        {
           try{

               Long movieId = Long.valueOf(object.getInt("id"));
               actorsRepository.addMovieToActor(id,movieRepository.getMovieById(movieId));

           }catch (RuntimeException e)
           {
               throw new RuntimeException("Not Found");
           }


            return Response.ok(Response.Status.ACCEPTED).build();

        }

        return null;
    }


}
