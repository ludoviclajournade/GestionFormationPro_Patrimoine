/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entitie.Salle;
import entitie.Planning;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.Local;

/**
 *
 * @author alban
 */
@Local
public interface GestionPatrimoineLocal {
    
    public Salle ajouterSalle(String content);
    
    public Planning ajouterSallePan(String content);
    
    public Planning changerStatut(String content);
    
    public String SupprimerSallePlan(int id);
    
    public String SupprimerSalle(int id);
    
    public ArrayList<Planning> renvoiPlan();
    
    public HashMap<Integer, Salle> renvoiSalle();
    
    public ArrayList<Planning> renvoiPlanningSalles();
    
}
