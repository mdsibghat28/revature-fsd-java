package com.revature.springlearn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.revature.springlearn.exception.NotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseBody> handleException(Exception ex) {
    	if(ex instanceof NotFoundException) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
}