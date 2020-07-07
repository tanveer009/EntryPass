package com.entryPass.visitor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VisitorExceptionController {
	
	@ExceptionHandler(value = VisitorNotFoundException.class)
	public ResponseEntity<Object> exception(VisitorNotFoundException exception){
		return new ResponseEntity<Object>("Sorry, No Visitor Found!!", HttpStatus.NOT_FOUND);
		
	}

}
