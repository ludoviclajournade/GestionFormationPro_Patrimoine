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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
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
    ServicePatrimoineLocal patri;
    private Gson gson;

    /**
     * Creates a new instance of PatrimoineResource
     */
    public PatrimoineResource() {
        patri = lookupServicesBourseLocal();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    
    @Path("afficherPlan")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String afficherPlan() {
        return this.gson.toJson(this.patri.renvoiPlan());
    }
    
    @Path("afficherSalle")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String afficherSalle() {
        return this.gson.toJson(this.patri.renvoiSalle());
    }
    
    @Path("afficherPlanSalles")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String afficherPlanningSalles() {
        return this.gson.toJson(this.patri.renvoiPlanningSalles());
    }

    @Path("SupprimerSalle")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String supprimerSalle(@QueryParam("idSalle") int id) {
        
        return patri.supprimerSalle(id);        
    }
    
    @Path("SupprimerSallePlan")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String supprimerSallePlan(@QueryParam("idSalle") int id, @QueryParam("dateDeb") String dateDeb) {
        return patri.supprimerSallePlan(id, dateDeb);        
    }
    
    
    @Path("AjoutSalle")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String ajouterSalle(String content) {
        return this.gson.toJson(patri.ajouterSalle(content));        
    }
    
    @Path("AjoutPlan")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String ajouterSallePan(String content) {
        return this.gson.toJson(patri.ajouterSallePan(content));        
    }
    
    @Path("changerStatut")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String changerStatut(String content) {
        return this.gson.toJson(patri.changerStatut(content));        
    }

    
    /**
     * PUT method for updating or creating an instance of PatrimoineResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
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
