package com.foo.bar.restful.foobarservice;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by emilkirschner on 11/10/15.
 */
@Path("foobar")
public class FooBarService {
    @Context
    ServletContext context;

    @GET
    @Produces("application/json")
    @PermitAll
    public Response all() {
        return Tasks.profile(context, "", () -> Response.ok(new Payload("delivery", 12), MediaType.APPLICATION_JSON_TYPE).build());
    }
}
