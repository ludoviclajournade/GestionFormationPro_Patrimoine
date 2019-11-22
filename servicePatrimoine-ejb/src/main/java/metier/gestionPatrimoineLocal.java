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
    
    public String ajouterSalle(String id_Sal) ;
    
    public String changerStatut(String content);
    
    public String SupprimerRes(String id_Sal) ;
    
    public String RenvoisPlan();
    
}
