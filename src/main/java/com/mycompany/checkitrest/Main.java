/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.checkitrest;

/**
 *
 * @author BEDAAR
 */

import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hauptklasse unseres kleinen Beispielprogramms. Sie implementiert ein kleines
 * Menüsystem zur Anzeige der vorhandenen Projects und zur Anlage eines neuen
 * Projects. Dabei greift sie auf die Klassen ProjectResource und Project zurück, die
 * passend zum Webservice angelegt wurden.
 */
public class Main {
    
    //Testcomment

    static BufferedReader fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
    static ProjectResource projectResource = new ProjectResource();

    /**
     * Hauptmenü des Programms. Zeigt alle vorhandenen Projects und fragt den
     * Anwender, ob er einen neuen Project anlegen oder das Programm beenden will.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        boolean quit = false;

        while (!quit) {
            // Alle Projets vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.println("Alle Projekten");
            System.out.println("================");
            System.out.println();

            Project[] projects = projectResource.findProjects("");

            if (projects != null) {
                for (Project project : projects) {
                    System.out.println("Projektname:       " + project.shorttext);
                    System.out.println("ID: " + project.id);
                    System.out.println("Begindate:   " + project.begindate);
                    System.out.println("Begintime: " + project.begintime);
                    System.out.println("Duedate:       " + project.duedate);
                    System.out.println("Duetime:       " + project.duetime);
                    System.out.println("Extern:       " + project.extern);
                    System.out.println("longtext:       " + project.longtext);
                    System.out.println("Mitarbeiter 1:       " + project.mitarbeitername1);
                    System.out.println("Mitarbeiter 2:       " + project.mitarbeitername2);
                    System.out.println("Mitarbeiter 3:       " + project.mitarbeitername3);
                    System.out.println("Mitarbeiter 4:       " + project.mitarbeitername4);
                    System.out.println("Mitarbeiter 5:       " + project.mitarbeitername5);
                    System.out.println("Priority:       " + project.priority);
                    System.out.println("Status:       " + project.status);
                    System.out.println("Owner:       " + project.owner_username);
                    System.out.println("Abteilung:       " + project.abteilung);
                    
                    
                    System.out.println();
                }
            }

            // Benutzer fragen, ob er einen neuen Song anlegen will
            System.out.println("[A] Neuen Project anlegen");
            System.out.println("[E] Ende");
            System.out.println();

            System.out.print("Deine Auswahl: ");
            String command = fromKeyboard.readLine();

            System.out.println();

            switch (command.toUpperCase()) {
                case "A":
                    createNewProject();
                    break;
                case "E":
                    System.out.println("Bye, bye!");
                    quit = true;
                    break;
            }
        }
    }

    /**
     * Menü zum Anlegen eines neuen Songs.
     *
     * @throws IOException
     * @throws UnirestException
     * @throws WebAppException
     */
    public static void createNewProject() throws IOException, UnirestException, WebAppException {
        System.out.println("==================");
        System.out.println("Neuen Song anlegen");
        System.out.println("==================");
        System.out.println();

        Project project = new Project();

        System.out.print("Shorttext: ");
        project.shorttext = fromKeyboard.readLine();
    
        System.out.print("begindate: ");
        project.begindate = fromKeyboard.readLine();
        
        System.out.print("begintime: ");
        project.begintime = fromKeyboard.readLine();

        System.out.print("duedate: ");
        project.duedate = fromKeyboard.readLine();
    
        System.out.print("duetime: ");
        project.duetime = fromKeyboard.readLine();

        System.out.print("extern: ");
        project.extern = fromKeyboard.readLine();
        
        System.out.print("longtext: ");
        project.longtext = fromKeyboard.readLine();
        
        System.out.print("mitarbeitername1: ");
        project.mitarbeitername1 = fromKeyboard.readLine();

        System.out.print("mitarbeitername2: ");
        project.mitarbeitername2 = fromKeyboard.readLine();
        
 
        System.out.print("mitarbeitername3: ");
        project.mitarbeitername3 = fromKeyboard.readLine();
 
        
        System.out.print("mitarbeitername4: ");
        project.mitarbeitername4 = fromKeyboard.readLine();
        
        
        System.out.print("mitarbeitername5: ");
        project.mitarbeitername5 = fromKeyboard.readLine();
        
        
        System.out.print("prioriy: ");
        project.priority = fromKeyboard.readLine();
     
        System.out.print("Status: ");
        project.status = fromKeyboard.readLine();
        
    
        System.out.print("owner_username : ");
        project.shorttext = fromKeyboard.readLine();

        System.out.println();

        projectResource.saveNewSong(project);
    }
}
