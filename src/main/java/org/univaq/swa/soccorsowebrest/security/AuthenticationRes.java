package org.univaq.swa.soccorsowebrest.security;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.util.Map;

@Path("auth")
public class AuthenticationRes {

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(@Context UriInfo uriinfo, Map<String, String> credentials) {
        System.out.println("Credenziali ricevute: " + credentials); // Debug

        // Forza l'autenticazione positiva per testing
        String authToken = AuthHelpers.getInstance().issueToken(uriinfo, credentials.get("username"));

        return Response.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + authToken)
                .entity("ok")
                .build();
    }

    /*
     * @POST
     * 
     * @Path("login")
     * 
     * @Consumes(MediaType.APPLICATION_JSON)
     * public Response login(@Context UriInfo uriinfo, Map<String, String>
     * credentials) {
     * try {
     * 
     * if (AuthHelpers.getInstance().authenticateUser(credentials.getOrDefault(
     * "username", ""), credentials.getOrDefault("password", ""))) {
     * String authToken = AuthHelpers.getInstance().issueToken(uriinfo,
     * credentials.get("username"));
     * return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " +
     * authToken).build();
     * }
     * } catch (Exception e) {
     * //logging dell'errore
     * }
     * return Response.status(UNAUTHORIZED).build();
     * }
     */

    @DELETE
    @Path("logout")
    @Logged
    public Response logout(@Context ContainerRequestContext req) {
        // proprietà estratta dall'authorization header
        // e iniettata nella request dal filtro di autenticazione
        String token = (String) req.getProperty("token");
        AuthHelpers.getInstance().revokeToken(token);
        return Response.noContent().build();
    }

    // Metodo per fare "refresh" del token senza ritrasmettere le credenziali
    @GET
    @Path("refresh")
    @Logged
    public Response refresh(@Context ContainerRequestContext req, @Context UriInfo uriinfo) {
        String username = (String) req.getProperty("user");
        String newtoken = AuthHelpers.getInstance().issueToken(uriinfo, username);
        return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + newtoken).build();
    }
}
