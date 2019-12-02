/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entitie.Salle;
import entitie.planning;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author alban
 */
@Local
public interface ServicePatrimoineLocal {
    
    
    public String ajouterSalle(String content);
    
    public String SupprimerSallePlan(int id);
    
    public String changerStatut(String content) ;
    
    public ArrayList<planning> renvoiPlan();
    
    public ArrayList<Salle> renvoiSalle();
    
    public String SupprimerSalle(int id);
    
    public String ajouterSallePan(String content);
    
}
