package rest.services;

import dao.PeopleRepository;
import entity.Person;
import query.CommentQuery;
import query.Query;

import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/people")
public class PersonResource {

    @Inject
    PeopleRepository peopleRepository;




    @GET
    public Response getListPersonWithPageSize(@QueryParam("page") int page)
    {
        int pageMin = page * 10 - 10;
        int pageMax = page * 10;


        return Response.status(200).entity(peopleRepository.getlimitResult(pageMin,pageMax)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") Long id)
    {
        peopleRepository.remove(id);

        return Response.status(202).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePerson(@PathParam("id") Long id, Person person)
    {
         peopleRepository.update(id,person);



        return Response.status(202).build();
    }


}
