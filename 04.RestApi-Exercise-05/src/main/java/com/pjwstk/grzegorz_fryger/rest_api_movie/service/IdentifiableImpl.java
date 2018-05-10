package com.pjwstk.grzegorz_fryger.rest_api_movie.service;


import com.pjwstk.grzegorz_fryger.rest_api_movie.service.interfaces.Identifiable;

import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import java.util.concurrent.atomic.AtomicLong;



public class IdentifiableImpl implements Identifiable
{

    private  AtomicLong counter = new AtomicLong();





    public Long getCurrentId()
    {

        return counter.get();
    }

    public Long generateId() {

        return counter.incrementAndGet();
    }



}
