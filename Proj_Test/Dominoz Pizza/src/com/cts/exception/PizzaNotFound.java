package com.cts.exception;

public class PizzaNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PizzaNotFound(String message) {
		super(message);
	}
}
