/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.checkitrest;

import java.util.List;

/**
 *
 * @author BEDAAR
 */
/**
 * Antwortobjekt, das bei Auftreten einer Exception an den Client gesendet
 * wird.
 */
public class ExceptionResponse {
    public String exception;
    public String message;
    public List<Violation> violations;
    
    public static class Violation {
        public String path = "";
        public String message = "";
    }
}
