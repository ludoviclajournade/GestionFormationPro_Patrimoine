/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import com.google.gson.Gson;
import entitie.Salle;
import javax.ejb.Stateless;
import entitie.Planning;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author alban
 */
@Stateless
public class GestionPatrimoine implements GestionPatrimoineLocal {
    
    private Gson gson;
    
    public GestionPatrimoine() {
        this.gson = new Gson();
    }

    private ArrayList<Planning> monPlanning = initPlan();
    private HashMap<Integer, Salle> mesSalles = initSalle();
    
    private ArrayList<Planning> initPlan(){
        ArrayList<Planning> monPlanning = new ArrayList<>();
        /*Planning pla1 = new Planning(1,"indisponible","01/01/2020","01/09/2020");
        Planning pla2 = new Planning(2,2,"affectee","01/01/2020","01/04/2020");
        Planning pla3 = new Planning(3,3,"pressentie","09/01/2020","14/01/2020");
        Planning pla4 = new Planning(4,4,"affectee","01/01/2020","01/12/2020");
        Planning pla5 = new Planning(1,2,"affectee","10/01/2020","15/12/2020");*/
        Planning pla1 = new Planning(1,"indisponible","01/01/2020","01/09/2020");
        Planning pla2 = new Planning(2,2,"affecte","01/01/2020","04/01/2020");
        Planning pla3 = new Planning(3,3,"pressenti","11/02/2020","16/02/2020");
        Planning pla4 = new Planning(4,4,"affecte","25/10/2020","30/10/2020");
        Planning pla5 = new Planning(1,2,"affecte","10/01/2020","15/12/2020");
        monPlanning.add(pla1);
        monPlanning.add(pla2);
        monPlanning.add(pla3);
        monPlanning.add(pla4);
        monPlanning.add(pla5);
         
        return monPlanning;
    }
    
    private HashMap<Integer, Salle> initSalle(){
        HashMap<Integer, Salle> mesSalles = new HashMap<>();
        ArrayList<String> equ = new ArrayList<String>();
        
        Salle S1 = new Salle(1,"Rocher",equ);
        
        equ.add("20 tables");
        equ.add("40 chaises");
        
        Salle S2 = new Salle(2,"Moze",equ);
        
        equ.add("projecteur");
        equ.add("tableau numérique");
        
        Salle S3 = new Salle(3,"Duchar",equ);
        Salle S4 = new Salle(4,"Saufane",equ);
        Salle S5 = new Salle(5,"Coucou",equ);
        
        mesSalles.put(S1.getId(), S1);
        mesSalles.put(S2.getId(), S2);
        mesSalles.put(S3.getId(), S3);
        mesSalles.put(S4.getId(),S4);
        mesSalles.put(S5.getId(),S5);
         
        return mesSalles;
    }
    
    @Override
    public Salle ajouterSalle(String content){
        Salle S = this.gson.fromJson(content, Salle.class);
        Salle S2 = new Salle(mesSalles.size()+1, S.getName(),S.getEquipement());
        mesSalles.put(S2.getId(), S2);
        return S2;
    }
    
    @Override
    public Planning ajouterSallePan(String content){
        Planning pla = this.gson.fromJson(content, Planning.class);
        monPlanning.add(pla);
        return pla;
    }
    
    @Override
    public String changerStatut(String content) {
        Planning pla = this.gson.fromJson(content, Planning.class);       
        String res = null;
        Integer salle = null;
        
        for(int i = 0; i<monPlanning.size();i++){
            if(monPlanning.get(i).getIdSalle() == pla.getIdSalle()) {
                salle = pla.getIdSalle();
                if(monPlanning.get(i).getDateDeb().equals(pla.getDateDeb())){
                   monPlanning.get(i).setStatut(pla.getStatut());
                   monPlanning.get(i).setIdFormation(pla.getIdFormation());
                   monPlanning.get(i).setDateFin(pla.getDateFin());

                   if(pla.getStatut().equals("indisponible"))
                       monPlanning.get(i).setIdFormation(null);

                   res = "Mise a jour de la salle reussie.";
               }
            }     
        }
        
        if(salle == null)
            res = "Salle non existante dans le planning";
        else if(salle != null && res == null)
            res = "Reservation non existante dans le planning";
        
        return res;
    }
    
    @Override
    public String supprimerSallePlan(int id, String dateDeb){
        String res = "Salle non existante dans le planning";
        for(int i = 0; i<monPlanning.size();i++){
            if (monPlanning.get(i).getIdSalle() == id && monPlanning.get(i).getDateDeb().equals(dateDeb)){
                monPlanning.remove(i);
                res = "Salle bien enlevee du planning";
            }
        }
        return res;
    }
    
    @Override
    public String supprimerSalle(int id){
        String res = "Salle bien supprimee";
        if(!this.mesSalles.containsKey(id))
            res = "Salle inexistante";
        else 
            this.mesSalles.remove(id);
        return res;
    }
    
    @Override
    public ArrayList<Planning> renvoiPlan(){
        return this.monPlanning;
    }

    @Override
    public HashMap<Integer, Salle> renvoiSalle(){
        return this.mesSalles;
    }
    
    @Override
    public ArrayList<Planning> renvoiPlanningSalles() {
        ArrayList<Planning> planning = new ArrayList<>();
        Planning plan = null;
        for(Salle s : this.mesSalles.values()) {
            for(Planning p : this.monPlanning) {
                if(p.getIdSalle() == s.getId()) {
                    plan = p;
                    planning.add(plan);
                }
            }
            //si la salle n'est pas dans le planning
            if(plan == null) {
                Planning p = new Planning(s.getId(), "disponible", null, null);
                planning.add(p);
            }
            plan = null;
        }
        return planning;
    }
}


