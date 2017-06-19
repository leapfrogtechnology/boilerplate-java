package com.lftechnology.boilerplate.rs;

import java.util.UUID;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lftechnology.boilerplate.entity.User;
import com.lftechnology.boilerplate.exception.ObjectNotFoundException;
import com.lftechnology.boilerplate.interceptor.Logged;
import com.lftechnology.boilerplate.service.UserService;
import com.lftechnology.boilerplate.util.GuidUtil;

/**
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
@Logged
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserRs {

    @Inject
    private UserService userService;

    @GET
    @Path("/")
    public Response list() {
        User user = new User();
        user.setAddress("Kathmandu");
        user.setId(GuidUtil.generate());
        user.setName("Ram");
        return Response.status(Response.Status.OK).entity(user).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@NotNull(message = "Request body expected") @Valid User user) {
        return Response.status(Status.OK).entity(userService.save(user)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") UUID id, @NotNull(message = "Request body expected") @Valid User user) {
        return Response.status(Response.Status.OK).entity(userService.merge(id, user)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") UUID id) {
        User user = userService.findById(id);
        if (user != null) {
            return Response.status(Response.Status.OK).entity(user).build();
        } else {
            throw new ObjectNotFoundException();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") UUID id) {
        userService.removeById(id);
        return Response.status(Response.Status.OK).build();
    }

}
