/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.soap.SOAPException;
import facades.planningFacadeLocal;
import entitie.planning;

/**
 *
 * @author alban
 */
@Stateless
public class gestionPatrimoine implements gestionPatrimoineLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //@EJB
    private planningFacadeLocal planningFacade;
    
    @Override
    public void ajouterSalle(long id_Sal) throws SOAPException {
        try {
            
            planning pla = new planning(id_Sal);
            this.planningFacade.create(pla);
           
        }
        catch (Exception e) {
            throw new SOAPException("Création du client échouée !");
        }
    }
    
    @Override
    public void changerStatut(long id_Sal, String statut) throws SOAPException {
        try {
            
            final planning pla = planningFacade.find(id_Sal);
            pla.setStatut(statut);
            this.planningFacade.edit(pla);
           
        }
        catch (Exception e) {
            throw new SOAPException("Création du client échouée !");
        }
    }
    
    @Override
    public void SupprimerRes(long id_Sal) throws SOAPException {
        try {
            
            final planning pla = planningFacade.find(id_Sal);
            pla.setStatut("libre");
            this.planningFacade.edit(pla);
           
        }
        catch (Exception e) {
            throw new SOAPException("Création du client échouée !");
        }
    }
}


