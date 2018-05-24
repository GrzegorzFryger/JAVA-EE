package pjwstk.fryger.computerstore;

import pjwstk.fryger.computerstore.service.ComputerStoreException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ComputerStoreExceptionMapper implements ExceptionMapper<ComputerStoreException> {

    @Override
    public Response toResponse(ComputerStoreException e)
    {
        return Response.serverError()
                .header("Error", e.getMessage())
                .entity(e.getMessage())
                .build();
    }
}
