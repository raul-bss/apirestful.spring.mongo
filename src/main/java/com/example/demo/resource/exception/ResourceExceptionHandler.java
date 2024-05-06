package com.example.demo.resource.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.service.exception.ObjectNotFound;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFound.class)
	public ResponseEntity<StandartError> resourceNotFound(ObjectNotFound e, HttpServletRequest request){
		String msg = "Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandartError error = new StandartError(Instant.now(),status,msg,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
}
