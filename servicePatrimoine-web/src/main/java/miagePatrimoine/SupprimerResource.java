/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miagePatrimoine;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import services.ServicePatrimoineLocal;

/**
 * REST Web Service
 *
 * @author alban
 */
@Path("Supprimer")
@RequestScoped
public class SupprimerResource {

    @Context
    private UriInfo context;

    
    ServicePatrimoineLocal patri = lookupServicesBourseLocal(); ;
    private Gson gson;
    /**
     * Creates a new instance of SupprimerResource
     */
    public SupprimerResource() {
    }

    /**
     * Retrieves representation of an instance of helloworld.SupprimerResource
     * @return an instance of java.lang.String
     */
    @GET
    public String getJson() {
        //TODO return proper representation object
        return "test";
    }

    /**
     * PUT method for updating or creating an instance of SupprimerResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    public String SupprimerRes(String id) {
        //return Response.ok(gson.toJson(patri.ajouterSalle(id))).build();
        System.out.print("coucou 1" + id);
        return patri.SupprimerRes(id);
    }
    
     private ServicePatrimoineLocal lookupServicesBourseLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (ServicePatrimoineLocal) c.lookup("java:global/servicePatrimoine-ear/servicePatrimoine-ejb-1.0-SNAPSHOT/ServicePatrimoine!services.ServicePatrimoineLocal");
            
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
