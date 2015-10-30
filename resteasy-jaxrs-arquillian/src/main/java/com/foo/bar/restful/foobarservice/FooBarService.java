package com.foo.bar.restful.foobarservice;


import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by emilkirschner on 11/10/15.
 */
@Path("foobar")
public class FooBarService {
    @GET
    @Produces("application/json")
    @PermitAll
    public Response all() {
        return Response.ok(new Payload("delivery", 12), MediaType.APPLICATION_JSON_TYPE).build();
    }
}
