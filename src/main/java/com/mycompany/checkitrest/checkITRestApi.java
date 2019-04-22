/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.checkitrest;

import java.util.HashSet;
import java.util.Set;
import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;



/**
* Einstiegspunkt für unseren REST-Webservice. Hier werden der URL-Prefix aller
* Aufrufe definiert (über @ApplicationPath) sowie alle Collections und Ressourcen
* dem Webservice hinzugefügt. Diese Klasse muss daher immer angepasst werden,
* wenn weitere Collections oder Ressourcen hinzukommen.
 */
@ApplicationPath("api")
public class checkITRestApi extends Application{
    
        @Override
        public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        // Hier für jede Webservice-Klasse eine Zeile hinzufügen
        resources.add(ProjectResource.class);

        return resources;
    }
    
}
