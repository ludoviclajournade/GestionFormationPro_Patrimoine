/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javax.ejb.Local;
import javax.xml.soap.SOAPException;

/**
 *
 * @author alban
 */
@Local
public interface gestionPatrimoineLocal {
    
    public String ajouterSalle(String content);
    
     public String ajouterSallePan(String content);
    
    public String changerStatut(String content);
    
     public String SupprimerSallePlan(int id);
    
    public String SupprimerSalle(int id);
    
    public String RenvoisPlan();
    
    public String RenvoisSalle();
    
}
