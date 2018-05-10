package com.pjwstk.grzegorz_fryger.rest_api_movie.service;


import javax.ejb.ApplicationException;
import javax.ws.rs.InternalServerErrorException;

@ApplicationException
public class MovieExceptions extends Throwable
{
    public MovieExceptions(String message)
    {
        super(message);
    }
}
