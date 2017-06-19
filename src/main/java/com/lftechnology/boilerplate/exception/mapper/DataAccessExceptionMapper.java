package com.lftechnology.boilerplate.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.lftechnology.boilerplate.exception.DataAccessException;
import com.lftechnology.boilerplate.pojo.ErrorMessage;

/**
 * Exception mapper for {@link DataAccessException}
 * 
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 *
 */
@Provider
public class DataAccessExceptionMapper implements ExceptionMapper<DataAccessException> {

	@Override
	public Response toResponse(DataAccessException exception) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setCode(Response.Status.BAD_REQUEST.getStatusCode());
		errorMessage.setMessage(exception.getMessage());
		return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage())
				.type(MediaType.APPLICATION_JSON).build();
	}

}
