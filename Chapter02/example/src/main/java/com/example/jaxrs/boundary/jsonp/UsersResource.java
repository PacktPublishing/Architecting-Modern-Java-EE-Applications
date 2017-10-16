package com.example.jaxrs.boundary.jsonp;

import com.example.jaxrs.boundary.UserStore;
import com.example.jaxrs.entity.User;
import com.example.jaxrs.entity.ValidUser;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    UserStore userStore;

    @Context
    UriInfo uriInfo;

    @GET
    public List<User> getUsers() {
        return userStore.getUsers();
    }

    @GET
    @Path("{id}")
    public User getUser(@PathParam("id") long id) {
        return userStore.getUser(id);
    }

    @POST
    public Response createUser(@Valid @ValidUser JsonObject object) {
        User user = readUser(object);
        long id = userStore.create(user);

        URI userUri = uriInfo.getBaseUriBuilder()
                .path(UsersResource.class)
                .path(UsersResource.class, "getUser")
                .build(id);

        return Response.created(userUri).build();
    }

    private User readUser(JsonObject object) {
        User user = new User();
        user.setName(object.getString("name"));
        return user;
    }

}
