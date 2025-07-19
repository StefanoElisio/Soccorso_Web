package org.univaq.swa.soccorsowebrest.resources;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;

import org.univaq.swa.soccorsowebrest.NotFoundException;
import org.univaq.swa.soccorsowebrest.business.RequestsService;
import org.univaq.swa.soccorsowebrest.business.RequestsServiceFactory;
import org.univaq.swa.soccorsowebrest.model.Request;
import org.univaq.swa.soccorsowebrest.model.Request.Status;

@Path("/requests")
public class RequestsResource {

    private final RequestsService business;

    public RequestsResource() {
        this.business = RequestsServiceFactory.getRequestsService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addRequest(@Valid Request request, @Context UriInfo uriinfo) {
        String uid = business.addRequest(request);
        URI uri = uriinfo.getBaseUriBuilder()
                .path(RequestsResource.class)
                .path(uid)
                .build();
        return Response.created(uri).entity(uri.toString()).build();
    }

    @GET
    @Produces({ "application/json" })
    public Response getRequestsbyStatus(@QueryParam("status") Status status, @Context UriInfo uriinfo) {
        try {
            return Response.ok(business.getRequestsbyStatus(status)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Requests not found").build();
        }
    }

}
