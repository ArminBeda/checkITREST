package com.mycompany.checkitrest;



import java.net.URL;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


/**
 *
 * @author BEDAAR
 */
/**
 * Webservice-Stub für den Project-Webservice
 */
public class ProjectResource {

    public static final String URL = "https://localhost:8443/checkIT/api/Projects/";

    public String url = URL;
    public String username = "";
    public String password = "";

    Gson gson = new GsonBuilder().create();

    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public ProjectResource() {
    }

    public ProjectResource(String url) {
        this.url = url;
    }
    //</editor-fold>

    /**
     * Benutzername und Passwort für die Authentifizierung merken.
     *
     * @param username Benutzername
     * @param password Passwort
     */
    public void setAuthData(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * Project suchen.
     * 
     * @param query Suchbegriff
     * @return Gefundene Songs
     * @throws UnirestException HTTP-Fehler
     * @throws WebAppException Server-Fehler
     */
    public Project[] findProjects(String query) throws UnirestException, WebAppException {
        HttpResponse<String> httpResponse = Unirest.get(this.url)
                .queryString("query", query)
                .header("accept", "application/json")
                .asString();
        
        try {
            ExceptionResponse er = this.gson.fromJson(httpResponse.getBody(), ExceptionResponse.class);
            
            if (er.exception != null) {
                throw new WebAppException(er);
            }
        } catch (JsonSyntaxException ex) {
            // Okay, keine Exception empfangen
        }
        
        return this.gson.fromJson(httpResponse.getBody(), Project[].class);
    }
    
    /**
     * Neuen Project speichern.
     * 
     * @param project Zu speichernder Project
     * @return Gespeicherter Project
     * @throws UnirestException HTTP-Fehler
     * @throws WebAppException Server-Fehler
     */
    public Project saveNewSong(Project project) throws UnirestException, WebAppException {
        HttpResponse<String> httpResponse = Unirest.post(this.url)
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .basicAuth(this.username, this.password)
                .body(this.gson.toJson(project))
                .asString();
        
        try {
            ExceptionResponse er = this.gson.fromJson(httpResponse.getBody(), ExceptionResponse.class);
            
            if (er.exception != null) {
                throw new WebAppException(er);
            }
        } catch (JsonSyntaxException ex) {
            // Okay, keine Exception empfangen
        }
        
        return this.gson.fromJson(httpResponse.getBody(), Project.class);
    }
    
    /**
     * Einzelnen Project auslesen.
     * 
     * @param id Project-ID
     * @return Gefundener Project
     * @throws UnirestException HTTP-Fehler
     * @throws WebAppException Server-Fehler
     */
    public Project getProject(long id) throws UnirestException, WebAppException {
        HttpResponse<String> httpResponse = Unirest.get(this.url + id + "/")
                .header("accept", "application/json")
                .asString();
        
        try {
            ExceptionResponse er = this.gson.fromJson(httpResponse.getBody(), ExceptionResponse.class);
            
            if (er.exception != null) {
                throw new WebAppException(er);
            }
        } catch (JsonSyntaxException ex) {
            // Okay, keine Exception empfangen
        }
        
        return this.gson.fromJson(httpResponse.getBody(), Project.class);
    }
    
    /**
     * Aktualisieren eines Projects.
     * 
     * @param project Zu speichernder Project
     * @return Gespeicherter Project
     * @throws UnirestException HTTP-Fehler
     * @throws WebAppException Server-Fehler
     */
    public Project updateProject(Project project) throws UnirestException, WebAppException {
        HttpResponse<String> httpResponse = Unirest.post(this.url + project.id + "/")
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .basicAuth(this.username, this.password)
                .body(this.gson.toJson(project))
                .asString();
        
        try {
            ExceptionResponse er = this.gson.fromJson(httpResponse.getBody(), ExceptionResponse.class);
            
            if (er.exception != null) {
                throw new WebAppException(er);
            }
        } catch (JsonSyntaxException ex) {
            // Okay, keine Exception empfangen
        }
        
        return this.gson.fromJson(httpResponse.getBody(), Project.class);
    }
    
    /**
     * Project löschen.
     * 
     * @param id Project-ID
     * @return Gelöschter Project
     * @throws UnirestException HTTP-Fehler
     * @throws WebAppException Server-Fehler
     */
    public Project deleteProject(long id) throws UnirestException, WebAppException {
        HttpResponse<String> httpResponse = Unirest.delete(this.url + id + "/")
                .header("accept", "application/json")
                .basicAuth(this.username, this.password)
                .asString();
        
        try {
            ExceptionResponse er = this.gson.fromJson(httpResponse.getBody(), ExceptionResponse.class);
            
            if (er.exception != null) {
                throw new WebAppException(er);
            }
        } catch (JsonSyntaxException ex) {
            // Okay, keine Exception empfangen
        }
        
        return this.gson.fromJson(httpResponse.getBody(), Project.class);
    }
    
}