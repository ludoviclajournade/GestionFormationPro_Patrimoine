/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.soap.SOAPException;
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
    
    private ArrayList<planning> initPlan(){
         ArrayList<planning> monPlanning = new ArrayList<planning>();
         planning pla1 = new planning("SA","Occupe","13/09/2019","14/09/2019 ");
         planning pla2 = new planning("SB","Libre"," "," ");
         planning pla3 = new planning("SC","Occuper","23/08/2019","25/08/2019 ");
         planning pla4 = new planning("SD","Libre"," "," ");
         monPlanning.add(pla1);
         monPlanning.add(pla2);
         monPlanning.add(pla3);
         monPlanning.add(pla4);
         
         return monPlanning;
    }
    
    @Override
    public String ajouterSalle(String id_Sal)  {
       
        
            planning pla = new planning(id_Sal,"libre"," "," "); 
            System.out.println(id_Sal);
            System.out.println(pla.toString());
            monPlanning.add(pla);
            return pla.toString();
    }
    
    @Override
    public String changerStatut(String content) {
        System.out.println("changer statut" + content);
        //content = gson.toJson(content);
        planning pla = this.gson.fromJson(content, planning.class);
        
        System.out.println(pla.toString());
        String res = "";
        for(int i = 0; i<monPlanning.size();i++){
            if (monPlanning.get(i).getId().equals(pla.getId())){
                monPlanning.get(i).setStatut(pla.getStatut());
                res = monPlanning.get(i).toString();
            }
        }
        return res;
    }
    
    @Override
    public String SupprimerRes(String id_Sal){
        System.out.print("coucou 3" + id_Sal);
        String res = "";
        for(int i = 0; i<monPlanning.size();i++){
             System.out.print("test" + i + " est " + monPlanning.get(i).getId());
            if (monPlanning.get(i).getId().equals(id_Sal)){
                monPlanning.get(i).setStatut("Libre");
                res = monPlanning.get(i).toString();
            }
        }
        return res;
    }
    
    @Override
    public String RenvoisPlan(){
        //System.out.print("coucou 3" + id_Sal);
        String res = "";
        String Newligne=System.getProperty("line.separator"); 
        for(int i = 0; i<monPlanning.size();i++){
            // System.out.print("test" + i + " est " + monPlanning.get(i).getId());
                res = res + monPlanning.get(i).toString() + Newligne;
            }
        return res;
    }
}


