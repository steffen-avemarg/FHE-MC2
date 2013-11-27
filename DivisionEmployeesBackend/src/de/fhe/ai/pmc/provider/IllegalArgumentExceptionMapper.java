package de.fhe.ai.pmc.provider;

import com.sun.jersey.api.Responses;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException>
{
    @Override
    public Response toResponse( IllegalArgumentException e )
    {
        return Response.status( Responses.CLIENT_ERROR ).
                entity( e.getMessage() ).
                type("text/plain").
                build();
    }
}
