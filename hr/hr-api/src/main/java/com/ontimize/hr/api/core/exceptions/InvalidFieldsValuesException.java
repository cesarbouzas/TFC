package com.ontimize.hr.api.core.exceptions;

public class InvalidFieldsValuesException extends ValidateException{

	public InvalidFieldsValuesException() {
		super();
	}
	public InvalidFieldsValuesException(String msg) {		
		super(msg);
	}
}
