/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entitie.planning;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alban
 */
@Local
public interface planningFacadeLocal {

    void create(planning planning);

    void edit(planning planning);

    void remove(planning planning);

    planning find(Object id);

    List<planning> findAll();

    List<planning> findRange(int[] range);

    int count();

    public planning AjouterSalle(long id);
    
}
