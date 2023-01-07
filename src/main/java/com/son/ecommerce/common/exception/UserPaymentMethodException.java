package com.son.ecommerce.common.exception;

public class UserPaymentMethodException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserPaymentMethodException(String message) {
		super(message);
	}
}
