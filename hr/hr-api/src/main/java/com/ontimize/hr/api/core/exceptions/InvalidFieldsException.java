package com.ontimize.hr.api.core.exceptions;

public class InvalidFieldsException extends ValidateException{

	public InvalidFieldsException() {
		super();
	}
	public InvalidFieldsException(String msg) {		
		super(msg);
	}
}
