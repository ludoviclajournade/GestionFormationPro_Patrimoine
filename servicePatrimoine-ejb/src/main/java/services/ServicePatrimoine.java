/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

//import metier.gestionPatrimoine;
import com.google.gson.Gson;
import entitie.Salle;
import entitie.Planning;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import metier.GestionPatrimoineLocal;

/**
 *
 * @author alban
 */
@Stateless
public class ServicePatrimoine implements ServicePatrimoineLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private GestionPatrimoineLocal gestionpatrimoine;
    /**
     * Convertisseur Objet JSON et inversement)
     */
    private Gson gson;

    /**
     * Constructeur par défaut de l'exposition
     */
    public ServicePatrimoine() {
        this.gson = new Gson();
    }
    
    @Override
    public String ajouterSalle(String content){
        return this.gestionpatrimoine.ajouterSalle(content);
    }
    @Override
    public String ajouterSallePan(String content){
        return this.gestionpatrimoine.ajouterSallePan(content);
    }
    
    @Override
    public String changerStatut(String content){
        return this.gestionpatrimoine.changerStatut(content);
    }
    
    @Override
    public String SupprimerSalle(int id){
        return this.gestionpatrimoine.SupprimerSalle(id);
    }
    
    @Override
    public String SupprimerSallePlan(int id){
        return this.gestionpatrimoine.SupprimerSallePlan(id);
    }
    
    @Override
    public HashMap<Integer, Planning> renvoiPlan() {
        return this.gestionpatrimoine.renvoiPlan();
    }
    
    @Override
    public HashMap<Integer, Salle> renvoiSalle(){
        return this.gestionpatrimoine.renvoiSalle();
    }   
    
    @Override
     public ArrayList<Planning> renvoiPlanningSalles() {
         return this.gestionpatrimoine.renvoiPlanningSalles();
     }
    
}
