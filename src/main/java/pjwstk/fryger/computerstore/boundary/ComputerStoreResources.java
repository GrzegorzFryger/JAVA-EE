package pjwstk.fryger.computerstore.boundary;

import pjwstk.fryger.computerstore.entity.Comment;
import pjwstk.fryger.computerstore.entity.ComputerPartCategory;
import pjwstk.fryger.computerstore.entity.Part;
import pjwstk.fryger.computerstore.repository.ComputerPartsRepositoryTemp;
import pjwstk.fryger.computerstore.repository.PartsRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

import static pjwstk.fryger.computerstore.query.PartsQuery.*;

/**
 *
 * @author airhacks.com
 */
@Path("ComputerStore")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComputerStoreResources
{
   @Inject
   ComputerPartsRepositoryTemp computerparts;

   @Inject
   PartsRepository partsRepository;


    @Context
    UriInfo uriInfo;


  @GET
  @Path("/computerparts")
    public Response getAllComputerParts()
  {

      List<Part> partList;

      try
      {
          partList =  partsRepository.query(allParts());

      }catch (RuntimeException e)
      {

         return Response.serverError().build();
      }

      return Response.status(200).entity(partList).build();


  }


    @GET
    @Path("/computerparts/query")
    public Response getPartByFilter(@QueryParam("price_from") int from,
                                  @QueryParam("price_to") int to,
                                  @QueryParam("name") String name,
                                  @QueryParam("orderBy") ComputerPartCategory  orderBy)
    {




        if ((from !=0) && (to != 0)) {
            return Response.status(200).entity(partsRepository.query(fidndByPrice(from, to))).build();
        }
        if (name != null) {
            return   Response.status(200).entity(partsRepository.query(findByName(name))).build();
        }
        if (orderBy != null) {
            return Response.status(200).entity(partsRepository.query(findByCategory(orderBy))).build();
        }


        return Response.status(404).entity("brak").build();


    }



    @GET
    @Path("/computerparts/{id}")
    public Response getComputerPartsById(@PathParam("id") @Min(0) Long id)
  {
      Part part;

      try
      {
          part = partsRepository.getById(id);

      }catch (RuntimeException e)
      {
          throw new RuntimeException(e);
      }


      return Response.status(200).entity(part).build();

  }

  @POST
  @Path("/computerparts")
  public Response addComputerPart(@Valid  Part part)
  {

      Long id;

      try
      {
         id = partsRepository.add(part);

      }catch (RuntimeException e)
      {
          throw new RuntimeException(e);
      }

      URI uri = uriInfo.getBaseUriBuilder()
              .path(ComputerStoreResources.class)
              .path("/")
              .path(ComputerStoreResources.class, "getComputerPartsById").build(id);

      return Response.ok(uri).build();

  }

  @PUT
  @Path("/computerparts/{id}")
  public Response updateComputerPart(@PathParam("id") @Min(0) Long id, @Valid @NotNull Part part)
  {


      try {

          computerparts.updatePart(id,part);

      }catch (RuntimeException e)
      {
          throw new RuntimeException(e);
      }

      URI uri = uriInfo.getBaseUriBuilder()
              .path(ComputerStoreResources.class)
              .path("/")
              .path(ComputerStoreResources.class, "getComputerPartsById").build(id);

      return Response.ok(uri).build();
  }

    @GET
    @Path("/computerparts/{id}/comments")
    public Response getAllCommentPart(@PathParam("id") @Min(0) Long id)
    {

        List<Comment> comments;

        try
        {

          comments =  computerparts.getAllComments();

        }catch (RuntimeException e)
        {
            throw new RuntimeException(e);
        }

        return Response.ok(comments).build();
    }

    @POST
    @Path("/computerparts/{id}/comments")
    public Response addCommentToPart(@PathParam("id") @Min(0) Long id, @Valid @NotNull Comment comment)
    {
        try
        {
            computerparts.addComment(id,comment);

        }catch (RuntimeException e)
        {
            throw new RuntimeException(e);
        }

        URI uri = uriInfo.getBaseUriBuilder()
                .path(ComputerStoreResources.class)
                .path("/")
                .path(ComputerStoreResources.class, "getAllCommentPart").build(id);

        return Response.ok(uri).build();

    }

    @DELETE
    @Path("/computerparts/{id}/comments/{idComment}")
    public Response deleteCommentFromPart(@PathParam("id") @Min(0) Long id, @PathParam("idComment") @Min(0) Long idComment)
    {
        try {

            computerparts.deleteComment(id,idComment);

        }catch (RuntimeException e)
        {
            throw new RuntimeException(e);
        }

        return Response.ok(Response.Status.OK).build();
    }






}
