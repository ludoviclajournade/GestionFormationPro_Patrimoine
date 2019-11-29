package helloworld;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alban
 */
import java.util.Set;
import javax.ws.rs.core.Application;
/**
 *
 * ApplicationConfig. Servlet hébergeant l'exposition des Ressources REST
 *
 * @author Cédric Teyssié  <cedric.teyssie@irit.fr>, IRIT-SIERA, Université Paul Sabatier
 * @version 0.1, 11 oct. 2019
 * @since 0.1, 11 oct. 2019
 */
// miagebourse-web
// fr.miage.toulouse.m2.eai.miagebourse.expo.rest
// ApplicationConfig.java
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically populated with all resources defined in the project. If required,
     * comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(miagePatrimoine.ModifResource.class);
        resources.add(miagePatrimoine.PatrimoineResource.class);
        resources.add(miagePatrimoine.SupprimerResource.class);
        resources.add(miagePatrimoine.TestResource.class);
    }

}
