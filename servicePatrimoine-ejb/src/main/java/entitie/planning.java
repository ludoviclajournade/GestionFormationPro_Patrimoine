/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

import javax.persistence.Column;

/**
 *
 * @author alban
 */
public class planning {

    @Override
    public String toString() {
        return "planning{" + "id=" + id + ", statut=" + statut + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + '}';
    }
        
    private String id;
    private String statut;
    private String dateDeb;
    private String dateFin;

    public planning(String id, String statut, String dateDeb, String dateFin) {
        this.id = id;
        this.statut = statut;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }

   
    

    public void setId(String id) {
        this.id = id;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setDateDeb(String dateDeb) {
        this.dateDeb = dateDeb;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    
    public String getId() {
        return id;
    }

    public String getStatut() {
        return statut;
    }

    public String getDateDeb() {
        return dateDeb;
    }

    public String getDateFin() {
        return dateFin;
    }
    
    
}
