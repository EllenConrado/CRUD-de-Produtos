package com.openbanking.Cruddeprodutos.service.exception;

public class InternalServerErrorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InternalServerErrorException(String msg) {
		super(msg);
	}

}
