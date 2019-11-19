/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import metier.gestionPatrimoine;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import entitie.planning;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.soap.SOAPException;

/**
 *
 * @author alban
 */
@Stateless
public class ServicePatrimoine implements ServicePatrimoineLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private gestionPatrimoine gestionpatrimoine;
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
    public String ajouterSalle(long id_sal) throws SOAPException{
        
        this.gestionpatrimoine.ajouterSalle(id_sal);
        return this.gson.toJson("bien ajouté");
       
    }
    @Override
    public String changerStatut(long id_Sal, String statut) throws SOAPException {
      
            this.gestionpatrimoine.SupprimerRes(id_Sal);
            return this.gson.toJson("bien supprimé");

    }
    
    @Override
    public String SupprimerRes(long id_Sal,String statut) throws SOAPException {
        this.gestionpatrimoine.changerStatut(id_Sal,statut);
        return this.gson.toJson("Statut modifié");
    }
}
