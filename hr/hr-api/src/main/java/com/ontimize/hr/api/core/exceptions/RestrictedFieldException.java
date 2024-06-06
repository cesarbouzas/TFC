package com.ontimize.hr.api.core.exceptions;

public class RestrictedFieldException extends ValidateException{

	public RestrictedFieldException() {
		super();
	}
	public RestrictedFieldException(String msg) {		
		super(msg);
	}
}
