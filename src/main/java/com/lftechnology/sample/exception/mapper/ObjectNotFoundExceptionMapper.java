package com.lftechnology.sample.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.lftechnology.sample.exception.ObjectNotFoundException;
import com.lftechnology.sample.pojo.ErrorMessage;

/**
 * Exception mapper for {@link ObjectNotFoundException}
 * 
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
@Provider
public class ObjectNotFoundExceptionMapper implements ExceptionMapper<ObjectNotFoundException> {

    @Override
    public Response toResponse(ObjectNotFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setStatus(Status.NOT_FOUND.getStatusCode());
        return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
    }
}
