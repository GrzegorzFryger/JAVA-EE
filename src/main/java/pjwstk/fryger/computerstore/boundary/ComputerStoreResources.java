package pjwstk.fryger.computerstore.boundary;

import pjwstk.fryger.computerstore.entity.Comment;
import pjwstk.fryger.computerstore.entity.ComputerPartCategory;
import pjwstk.fryger.computerstore.entity.Part;
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


@Path("ComputerStore")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComputerStoreResources
{


   @Inject
   PartsRepository partsRepository;


    @Context
    UriInfo uriInfo;


  @GET
  @Path("/computerparts")
    public Response getAllComputerParts()
  {

      List<Part> partList = partsRepository.query(allParts());

      if(!partList.isEmpty()) {
          return Response.status(200).entity(partList).build();
      }
      else
          return Response.status(404).build();


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


        return Response.status(404).entity("Not found").build();


    }



    @GET
    @Path("/computerparts/{id}")
    public Response getComputerPartsById(@PathParam("id") @Min(0) Long id)
  {
      Part part = partsRepository.getById(id);

      if(part != null) {
          return Response.status(200).entity(part).build();
      } else
          return Response.status(404).entity("Not found").build();




  }

  @POST
  @Path("/computerparts")
  public Response addComputerPart(@Valid  Part part)
  {

      Long id = partsRepository.add(part);

      if (id != 0)
      {
          URI uri = uriInfo.getBaseUriBuilder()
                  .path(ComputerStoreResources.class)
                  .path("/")
                  .path(ComputerStoreResources.class, "getComputerPartsById").build(id);

          return Response.ok(uri).build();

      }else
          return Response.status(404).build();



  }

  @PUT
  @Path("/computerparts/{id}")
  public Response updateComputerPart(@PathParam("id") @Min(0) Long id, @Valid @NotNull Part part)
  {

      partsRepository.update(part,id);

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

        List<Comment> comments = partsRepository.getAllCommentPart(id);

        if(!comments.isEmpty())
        {
            return Response.status(200).entity(comments).build();
        }else
            return Response.status(404).build();


    }

    @POST
    @Path("/computerparts/{id}/comments")
    public Response addCommentToPart(@PathParam("id") @Min(0) Long id, @Valid @NotNull Comment comment)
    {

        partsRepository.addCommentToPart(id,comment);


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


        partsRepository.remove(id,idComment);

        return Response.status(200).build();
    }






}
