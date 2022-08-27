package com.openbanking.Cruddeprodutos.controller.exceptions;

import javax.servlet.http.HttpServletRequest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.openbanking.Cruddeprodutos.service.exception.BadRequestException;
import com.openbanking.Cruddeprodutos.service.exception.InternalServerErrorException;
import com.openbanking.Cruddeprodutos.service.exception.NotFoundException;


@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionResponse> NotFound (NotFoundException e, HttpServletRequest request){
		ExceptionResponse err = new ExceptionResponse();
		err.setStatus_code(HttpStatus.NOT_FOUND.value());
		err.setMessage("NOT FOUND");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ExceptionResponse> BadRequest(BadRequestException e, HttpServletRequest request){
		ExceptionResponse err = new ExceptionResponse();
		err.setStatus_code(HttpStatus.BAD_REQUEST.value());
		err.setMessage("BAD REQUEST");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<ExceptionResponse> InternalServerError(InternalServerErrorException e, HttpServletRequest request){
		ExceptionResponse err = new ExceptionResponse();
		err.setStatus_code(HttpStatus.INTERNAL_SERVER_ERROR.value());
		err.setMessage("Internal Server Error");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
	}
}
