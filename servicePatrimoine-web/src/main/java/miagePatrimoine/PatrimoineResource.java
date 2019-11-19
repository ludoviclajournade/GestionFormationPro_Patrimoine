/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miagePatrimoine;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.xml.soap.SOAPException;
import services.ServicePatrimoineLocal;


/**
 * REST Web Service
 *
 * @author alban
 */
@Path("patrimoine")
@RequestScoped
public class PatrimoineResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PatrimoineResource
     */
    public PatrimoineResource() {
    }

    ServicePatrimoineLocal patri = lookupServicesBourseLocal(); ;
    private Gson gson;
    /**
     * Retrieves representation of an instance of miagePatrimoine.PatrimoineResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws SOAPException {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        //return Response.status(Response.Status.NOT_FOUND).build();
        
        return "test";
        
    }

    /**
     * PUT method for updating or creating an instance of PatrimoineResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(int content) throws SOAPException {
       // long id_sal;
   
       //planning p = gson.fromJson(content, planning.class)
        return Response.ok(gson.toJson(patri.ajouterSalle(content))).build();
    }
    
  
    //@Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    //@Path("/post")
    @POST
    public Response AjouterSalle(@PathParam("id") long id) throws SOAPException {
        return Response.ok(gson.toJson(patri.ajouterSalle(id))).build();
        //return "coucou";
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
