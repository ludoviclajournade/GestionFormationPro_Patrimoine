/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entitie.planning;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author alban
 */
@Stateless
public class planningFacade extends AbstractFacade<planning> implements planningFacadeLocal {

    @PersistenceContext(unitName = "miage_patrimoine-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public planningFacade() {
        super(planning.class);
    }
    
    @Override
    public planning AjouterSalle(long id) {
        planning p = new planning(id);
        this.create(p);
        return p;
    }
    

  
    
}
