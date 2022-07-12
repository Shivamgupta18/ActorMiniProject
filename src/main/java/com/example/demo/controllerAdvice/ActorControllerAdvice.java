package com.example.demo.controllerAdvice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.errordetails.ErrorDetails;
import com.example.demo.exception.ActorNotFoundException;

@RestControllerAdvice
public class ActorControllerAdvice {

	@ExceptionHandler(ActorNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleActorNotFoundException(ActorNotFoundException anfe){
		System.out.println("ActorControllerAdvice.handleActorNotFoundExceptin()");
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), "500", anfe.getMessage());
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> HandleAllException(Exception e){
		System.out.println("ActorCControllerAdvice.handleAllExcpetion()");
		ErrorDetails errs=new ErrorDetails(LocalDateTime.now(), "500", e.getMessage());
		return new ResponseEntity<ErrorDetails>(errs,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
