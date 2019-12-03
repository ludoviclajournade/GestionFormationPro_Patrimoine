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
        Planning pla1 = new Planning(1,"indisponible","01/01/2020","01/09/2020");
        Planning pla2 = new Planning(2,2,"affectée","01/01/2020","01/04/2020");
        Planning pla3 = new Planning(3,3,"pressentie","09/01/2020","14/01/2020");
        Planning pla4 = new Planning(4,4,"affectée","01/01/2020","01/12/2020");
        monPlanning.add(pla1);
        monPlanning.add(pla2);
        monPlanning.add(pla3);
        monPlanning.add(pla4);
         
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
    public Planning changerStatut(String content) {
        Planning pla = this.gson.fromJson(content, Planning.class);       
        Planning res = null;
        
        for(int i = 0; i<monPlanning.size();i++){
            if(monPlanning.get(i).getIdSalle() == pla.getIdSalle() && monPlanning.get(i).getIdFormation() == pla.getIdFormation()){
                monPlanning.get(i).setStatut(pla.getStatut());
                monPlanning.get(i).setDateDeb(pla.getDateDeb());
                monPlanning.get(i).setDateFin(pla.getDateFin());
                res = monPlanning.get(i);
            }
            if(monPlanning.get(i).getIdSalle() == pla.getIdSalle() && monPlanning.get(i).getIdFormation() == pla.getIdFormation() && pla.getStatut().equals("indisponible") ){
                monPlanning.get(i).setStatut(pla.getStatut());
                monPlanning.get(i).setDateDeb(pla.getDateDeb());
                monPlanning.get(i).setDateFin(pla.getDateFin());
                monPlanning.get(i).setIdFormation(0);
                res = monPlanning.get(i);
            }
        }
        return res;
    }
    
    @Override
    public String SupprimerSallePlan(int id){
        for(int i = 0; i<monPlanning.size();i++){
            if (monPlanning.get(i).getIdSalle() == id){
                monPlanning.remove(i);
            }
        }
        return "Salle bien enlevée du planning";
    }
    
    @Override
    public String SupprimerSalle(int id){
        String res = "Salle bien supprimée";
        if(!this.mesSalles.containsKey(id))
            res = "Salle inexistante";
        else 
            this.mesSalles.remove(id);
        return res;
    }
    
    /*@Override
    public String renvoiPlan(){
        String res = "";
        String Newligne=System.getProperty("line.separator"); 
        for(int i = 0; i<monPlanning.size();i++){
                res = res + monPlanning.get(i).toString() + Newligne;
            }
        return res;
    }*/
    
    @Override
    public ArrayList<Planning> renvoiPlan(){
        return this.monPlanning;
    }
    
   /* @Override
    public String renvoiSalle(){
        String res = "";
        String Newligne=System.getProperty("line.separator"); 
        for(int i = 0; i<mesSalles.size();i++){
                res = res + mesSalles.get(i).toString() + Newligne;
            }
        return res;
    }*/
    
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
                if(p.getIdSalle() == s.getId())
                    plan = p;
            }
            if(plan == null) {
                Planning p = new Planning(s.getId(), "disponible", null, null);
                planning.add(p);
            }
            else {
                planning.add(plan);
            }
            plan = null;
        }
        return planning;
    }
}


