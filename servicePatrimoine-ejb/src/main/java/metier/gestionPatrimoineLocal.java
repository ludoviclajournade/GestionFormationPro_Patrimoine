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
    
    void ajouterSalle(long id_Sal) throws SOAPException;
    
    public void changerStatut(long id_Sal, String statut) throws SOAPException ;
    
    public void SupprimerRes(long id_Sal) throws SOAPException;
}
