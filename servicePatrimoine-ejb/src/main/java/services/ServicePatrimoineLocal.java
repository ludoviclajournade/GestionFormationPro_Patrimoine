/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Local;
import javax.xml.soap.SOAPException;

/**
 *
 * @author alban
 */
@Local
public interface ServicePatrimoineLocal {
    
    
    public String ajouterSalle(long id_sal) throws SOAPException;
    
    public String SupprimerRes(long id_Sal,String statut) throws SOAPException;
    
    public String changerStatut(long id_Sal, String statut) throws SOAPException;
}
