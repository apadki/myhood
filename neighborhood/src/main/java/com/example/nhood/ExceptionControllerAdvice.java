package com.example.nhood;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
/*  @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler( org.hibernate.exception.ConstraintViolationException.class)
    public  @ResponseBody  ResponseEntity<String> handleHiberException( org.hibernate.exception.ConstraintViolationException ex, WebRequest request){
        System.out.println(" \n\n *** " +  " inhandleHiberException " + ex.getMessage());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Data Constraint violation" ,
               "Details");
            return new ResponseEntity<>("Data Exception at: " + request.getDescription(false), HttpStatus.NOT_FOUND);
           // return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }*/
    
      
    @Override
    protected ResponseEntity<Object> handleBindException(
      BindException ex, 
      HttpHeaders headers, 
      HttpStatus status, 
      WebRequest request) {
        List<String> errors = new ArrayList<String>();
        
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
         
        HoodError apiError = 
          new HoodError(HttpStatus.BAD_REQUEST, "Invalid "+ ex.getBindingResult().getObjectName(), errors);
        return handleExceptionInternal(
          ex, apiError, headers, apiError.getStatus(), request);
    }
    
    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(
      ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " + 
              violation.getPropertyPath() + ": " + violation.getMessage());
        }
     
        HoodError apiError = 
          new HoodError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<Object>(
          apiError, new HttpHeaders(), apiError.getStatus());
    }
    
    
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleSqlIntegroyException(
        SQLIntegrityConstraintViolationException ex, WebRequest request) {
          List<String> errors = new ArrayList<String>();
           
       
          HoodError apiError = 
            new HoodError(HttpStatus.BAD_REQUEST, ex.getMessage(), errors);
          return new ResponseEntity<Object>(
            apiError, new HttpHeaders(), apiError.getStatus());
      }
      
}
