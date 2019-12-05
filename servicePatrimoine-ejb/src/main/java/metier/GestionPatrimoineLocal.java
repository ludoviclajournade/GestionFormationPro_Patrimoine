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
    
    public String changerStatut(String content);
    
    public String supprimerSallePlan(int id, String dateDeb);
    
    public String supprimerSalle(int id);
    
    public ArrayList<Planning> renvoiPlan();
    
    public HashMap<Integer, Salle> renvoiSalle();
    
    public ArrayList<Planning> renvoiPlanningSalles();
    
}
