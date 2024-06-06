package com.ontimize.hr.api.core.exceptions;

public class MissingColumnsException extends ValidateException{
	
	public MissingColumnsException() {
		super();
	}
	public MissingColumnsException(String msg) {		
		super(msg);
	}

}
