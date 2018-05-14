package pjwstk.fryger.computerstore.boundary;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import pjwstk.fryger.computerstore.Comment;
import pjwstk.fryger.computerstore.entity.Part;
import pjwstk.fryger.computerstore.repository.ComputerPartsRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

/**
 *
 * @author airhacks.com
 */
@Path("ComputerStore")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComputerStoreResource
{
    @Inject
    ComputerPartsRepository computerparts;

    @Context
    UriInfo uriInfo;


  @GET
  @Path("/computerparts")
    public Response getAllComputerParts()
  {

      List<Part> partList;

      try
      {
        partList =  computerparts.getAll();

      }catch (RuntimeException e)
      {
          //add class exceptions handler
         return Response.serverError().build();
      }

      return Response.ok(Response.Status.OK).build();


  }

    @GET
    @Path("/computerparts")
    public String getPartByFilter(@Context UriInfo uriInfoForFilter)
    {
        MultivaluedMap<String, String> params =
                uriInfoForFilter.getQueryParameters();

      return  params.getFirst("name");



    }

    @GET
    @Path("/computerparts/{id}")
    public Response getComputerPartsById(@PathParam("id") @Min(0) Long id)
  {
      Part part;

      try
      {
          part = computerparts.getById();

      }catch (RuntimeException e)
      {
          throw new RuntimeException(e);
      }


      return Response.ok(Response.Status.OK).build();

  }

  @POST
  @Path("/computerparts")
  public Response addComputerPart(@Valid @NotNull Part part)
  {

      Long id;

      try
      {
         id = computerparts.addPart(part);

      }catch (RuntimeException e)
      {
          throw new RuntimeException(e);
      }

      URI uri = uriInfo.getBaseUriBuilder()
              .path(ComputerStoreResource.class)
              .path("/")
              .path(ComputerStoreResource.class, "getComputerPartsById").build(id);

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
              .path(ComputerStoreResource.class)
              .path("/")
              .path(ComputerStoreResource.class, "getComputerPartsById").build(id);

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
                .path(ComputerStoreResource.class)
                .path("/")
                .path(ComputerStoreResource.class, "getAllCommentPart").build(id);

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
