package org.univaq.swa.soccorsowebrest.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.core.UriInfo;
import java.io.InputStream;

import org.univaq.swa.soccorsowebrest.DatabaseException;
import org.univaq.swa.soccorsowebrest.NotFoundException;
import org.univaq.swa.soccorsowebrest.business.RequestsService;
import org.univaq.swa.soccorsowebrest.business.RequestsServiceFactory;
import org.univaq.swa.soccorsowebrest.model.Request;
import org.univaq.swa.soccorsowebrest.security.Logged;

public class RequestResource {

    private final RequestsService business;
    private final Request request;

    public RequestResource(Request r) {
        this.business = RequestsServiceFactory.getRequestsService();
        this.request = r;
    }

    @GET
    @Produces({ "application/json" })
    public Response getRequest() {
        return Response.ok(request).build();
    }

    @Logged
    @DELETE
    public Response deleteRequest(@Context SecurityContext securityContext) {
        try {
            business.deleteRequest(request.getUid());
            return Response.noContent().build();
        } catch (NotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity("Request not found").build();
        } catch (DatabaseException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }

    @Logged
    @PUT
    @Path("/photo")
    @Consumes(MediaType.WILDCARD)
    public Response updatePhoto(@Context UriInfo c,InputStream data) {
        try {
            business.updatePhoto(request.getUid(), data);
        } catch (NotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity("Request not found").build();
        } catch (DatabaseException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }
        return Response.noContent().build();
    }
}
