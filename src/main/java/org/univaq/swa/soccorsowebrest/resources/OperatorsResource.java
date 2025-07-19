package org.univaq.swa.soccorsowebrest.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.univaq.swa.soccorsowebrest.business.OperatorsService;
import org.univaq.swa.soccorsowebrest.business.OperatorsServiceFactory;
import org.univaq.swa.soccorsowebrest.model.Operator;
import org.univaq.swa.soccorsowebrest.security.Logged;

import java.util.List;

@Path("/operators")
public class OperatorsResource {

    private final OperatorsService business;

    public OperatorsResource(){
        this.business = OperatorsServiceFactory.getOperatorsService();
    }

    @GET
    @Path("/free")
    @Produces(MediaType.APPLICATION_JSON)
    @Logged
    public Response getFreeOperators() {
        try {
            List<Operator> operators = business.getFreeOperators();
            return Response.ok(operators).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}