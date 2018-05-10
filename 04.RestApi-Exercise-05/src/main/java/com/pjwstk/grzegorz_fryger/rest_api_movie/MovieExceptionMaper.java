package com.pjwstk.grzegorz_fryger.rest_api_movie;

import com.pjwstk.grzegorz_fryger.rest_api_movie.service.MovieExceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MovieExceptionMaper  implements ExceptionMapper<MovieExceptions> {



    @Override
    public Response toResponse(MovieExceptions movieExceptions) {
       // return Response.serverError()
        // .header("Movie Data Problem",movieExceptions.getMessage())
        // .entity(movieExceptions.getMessage()).build();

        return  Response.status(Response.Status.OK)
                .entity(movieExceptions.getMessage())
                .type(MediaType.APPLICATION_JSON).build();
    }
}
