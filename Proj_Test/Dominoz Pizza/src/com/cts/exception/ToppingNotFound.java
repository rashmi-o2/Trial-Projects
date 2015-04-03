package com.cts.exception;

public class ToppingNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ToppingNotFound(String message) {
		super(message);
	}
}
