/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import com.google.gson.Gson;
import entitie.Salle;
import javax.ejb.Stateless;
import entitie.planning;
import java.util.ArrayList;

/**
 *
 * @author alban
 */
@Stateless
public class gestionPatrimoine implements gestionPatrimoineLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
   
    private Gson gson;
    
    public gestionPatrimoine() {
        this.gson = new Gson();
    }

    private ArrayList<planning> monPlanning = initPlan();
    private ArrayList<Salle> mesSalles = initSalle();
    
    private ArrayList<planning> initPlan(){
         ArrayList<planning> monPlanning = new ArrayList<planning>();
         planning pla1 = new planning(1,"indisponible","01/01/2020","01/09/2020");
         planning pla2 = new planning(2,2,"affectée","01/01/2020","01/04/2020");
         planning pla3 = new planning(3,3,"pressentie","09/01/2020","14/01/2020");
         planning pla4 = new planning(4,4,"affectée","01/01/2020","01/12/2020");
         monPlanning.add(pla1);
         monPlanning.add(pla2);
         monPlanning.add(pla3);
         monPlanning.add(pla4);
         
         return monPlanning;
    }
    
    private ArrayList<Salle> initSalle(){
        ArrayList<Salle> mesSalles = new ArrayList<Salle>();
        ArrayList<String> equ = new ArrayList<String>();
        
        Salle S1 = new Salle(1,"Rocher",equ);
        
        equ.add("20 tables");
        equ.add("40 chaises");
        
        Salle S2 = new Salle(2,"Moze",equ);
        
        equ.add("projecteur");
        equ.add("tableau numérique");
        
        Salle S3 = new Salle(3,"Duchar",equ);
        Salle S4 = new Salle(4,"Saufane",equ);
        
        mesSalles.add(S1);
        mesSalles.add(S2);
        mesSalles.add(S3);
        mesSalles.add(S4);
         
        return mesSalles;
    }
    
    @Override
    public String ajouterSalle(String content){
        Salle S = this.gson.fromJson(content, Salle.class);
        Salle S2 = new Salle(mesSalles.size()+1, S.getName(),S.getEquipement());
        mesSalles.add(S2);
        return S2.toString();
    }
    
    @Override
    public String ajouterSallePan(String content){
        planning pla = this.gson.fromJson(content, planning.class);
        monPlanning.add(pla);
        return pla.toString();
    }
    
    @Override
    public String changerStatut(String content) {
        planning pla = this.gson.fromJson(content, planning.class);
        
        System.out.println(pla.toString());
        String res = "";
        for(int i = 0; i<monPlanning.size();i++){
            if(monPlanning.get(i).getIdSalle() == pla.getIdSalle() && monPlanning.get(i).getIdFormation() == pla.getIdFormation()){
                monPlanning.get(i).setStatut(pla.getStatut());
                monPlanning.get(i).setDateDeb(pla.getDateDeb());
                monPlanning.get(i).setDateFin(pla.getDateFin());
                res = monPlanning.get(i).toString();
            }
            if(monPlanning.get(i).getIdSalle() == pla.getIdSalle() && monPlanning.get(i).getIdFormation() == pla.getIdFormation() && pla.getStatut().equals("indisponible") ){
                monPlanning.get(i).setStatut(pla.getStatut());
                monPlanning.get(i).setDateDeb(pla.getDateDeb());
                monPlanning.get(i).setDateFin(pla.getDateFin());
                monPlanning.get(i).setIdFormation(0);
                res = monPlanning.get(i).toString();
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
        return "Salle bien enlevé du planning";
    }
    
    @Override
    public String SupprimerSalle(int id){
        for(int i = 0; i<mesSalles.size();i++){
            if (mesSalles.get(i).getId() == id){
                
                mesSalles.remove(i);
      
            }
        }
        
        return "Salle bien supprimé";
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
    public ArrayList<planning> renvoiPlan(){
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
    public ArrayList<Salle> renvoiSalle(){
        return this.mesSalles;
    }
}


