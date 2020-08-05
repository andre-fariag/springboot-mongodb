package com.course.demo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import com.course.demo.services.exception.ObjectNotfoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotfoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotfoundException e, HttpServletRequest request){
        
        HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not found", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
    }
}
