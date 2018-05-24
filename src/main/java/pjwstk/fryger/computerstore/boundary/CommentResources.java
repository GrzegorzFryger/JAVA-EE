package pjwstk.fryger.computerstore.boundary;


import pjwstk.fryger.computerstore.entity.Comment;
import pjwstk.fryger.computerstore.repository.CommentRepository;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static pjwstk.fryger.computerstore.query.CommentQuery.getAllComment;

@Path("CommentsStore")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResources
{

    @Inject
    CommentRepository commentRepository;




    @GET
    @Path("/comments")
    public Response getAllComputerParts()
    {

        List<Comment> commentList = commentRepository.query(getAllComment());

        if(!commentList.isEmpty()) {
            return Response.status(200).entity(commentList).build();
        }
        else
            return Response.status(404).build();


    }

    @DELETE
    @Path("/comment/{id}")
    public Response deleteCommentFromPart(@PathParam("id") @Min(0) Long id)
    {


       commentRepository.remove(id);

        return Response.status(200).build();
    }

}
