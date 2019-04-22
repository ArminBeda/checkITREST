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

import com.mycompany.checkitrest.ExceptionResponse;
import java.util.ArrayList;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * JAX-RS Exception Mapper für beliebige Exceptions. Dieser sorgt dafür, dass
 * bei Auftreten einer Exception dennoch eine ordentliche Antwort an den Client
 * gesendet wird.
 */
@Provider
public class RestExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable ex) {
        ExceptionResponse result = new ExceptionResponse();
        result.exception = ex.getClass().getName();
        result.message = ex.getMessage();

        if (ex instanceof ConstraintViolationException) {
            result.violations = new ArrayList<>();

            ConstraintViolationException cex = (ConstraintViolationException) ex;
            
            for (ConstraintViolation<?> constraintViolation : cex.getConstraintViolations()) {
                ExceptionResponse.Violation violation = new ExceptionResponse.Violation();
                
                violation.path = constraintViolation.getPropertyPath().toString();
                violation.message = constraintViolation.getMessage();
                
                result.violations.add(violation);
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
    }

}
