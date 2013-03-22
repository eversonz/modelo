package com.everson.common.exception;

public class NativeRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 9876545678987656L;

	public NativeRuntimeException(String error) {
		super(error);
	}
	
}
