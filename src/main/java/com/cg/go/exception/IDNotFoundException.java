package com.cg.go.exception;

public class IDNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IDNotFoundException(String msg) {
		super(msg);
	}

	public IDNotFoundException(String msg, Throwable e) {
		super(msg, e);
	}
}
