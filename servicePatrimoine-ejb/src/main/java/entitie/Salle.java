/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

import java.util.ArrayList;

/**
 *
 * @author alban
 */
public class Salle {
    
    private static int count = 0; 
    private int id;
    private String name;
    private ArrayList<String> equipement;

    public Salle(String name, ArrayList<String> equipement) {
        this.id = ++count;
        this.name = name;
        this.equipement = equipement;
    }
    
     public Salle(int id, String name, ArrayList<String> equipement) {
        this.id = id;
        this.name = name;
        this.equipement = equipement;
    }

    @Override
    public String toString() {
        return "Salle{" + "id=" + id + ", name=" + name + ", equipement=" + equipement + '}';
    }

     
    public static void setCount(int count) {
        Salle.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEquipement(ArrayList<String> equipement) {
        this.equipement = equipement;
    }
     
     

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getEquipement() {
        return equipement;
    }
     
     
    
    
    
}
