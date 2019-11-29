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
import javax.ws.rs.QueryParam;
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
    @Path("afficherPlan")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String afficherPlan() {
        //TODO return proper representation object
        return patri.RenvoisPlan();
    }
    
    @Path("afficherSalle")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String afficherSalle() {
        //TODO return proper representation object
        return patri.RenvoisSalle();
    }

    @Path("SupprimerSalle")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String SupprimerSalle(@QueryParam("idSalle") int id) {
        
        return patri.SupprimerSalle(id);        
    }
    
    @Path("SupprimerSallePlan")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String SupprimerSallePlan(@QueryParam("idPlan") int id) {
       
        return patri.SupprimerSallePlan(id);        
    }
    
    
    @Path("AjoutSalle")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String AjouterSalle(String content) {
        //return Response.ok(gson.toJson(patri.ajouterSalle(id))).build();
        //System.out.print(id);
        return patri.ajouterSalle(content);        
    }
    
    @Path("AjoutPlan")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String ajouterSallePan(String content) {
       
        return patri.ajouterSallePan(content);        
    }
    
    @Path("changerStatut")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String changerDate(String content) {
    
        return patri.changerStatut(content);        
    }
    
    
    
    
    /**
     * PUT method for updating or creating an instance of PatrimoineResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
       // long id_sal;
   
       //planning p = gson.fromJson(content, planning.class)
        //return Response.ok(gson.toJson(patri.ajouterSalle(content))).build();
        return "testOK";
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
