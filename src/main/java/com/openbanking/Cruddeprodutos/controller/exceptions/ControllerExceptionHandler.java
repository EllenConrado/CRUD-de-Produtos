package com.openbanking.Cruddeprodutos.controller.exceptions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.openbanking.Cruddeprodutos.service.exception.InternalServerErrorException;
import com.openbanking.Cruddeprodutos.service.exception.NotFoundException;


@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionResponse> NotFound (NotFoundException e, HttpServletRequest request){
		ExceptionResponse err = new ExceptionResponse();
		err.setStatus_code(HttpStatus.NOT_FOUND.value());
		err.setMessage("NOT FOUND");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException e){
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error)->{
		String fieldName = ((FieldError)error).getField();
		String errorMessage = error.getDefaultMessage();
		errors.put(fieldName, errorMessage);
	});
		return errors;
	}
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<ExceptionResponse> InternalServerError(InternalServerErrorException e, HttpServletRequest request){
		ExceptionResponse err = new ExceptionResponse();
		err.setStatus_code(HttpStatus.INTERNAL_SERVER_ERROR.value());
		err.setMessage("Internal Server Error");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
	}
}
