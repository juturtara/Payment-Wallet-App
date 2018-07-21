package com.capgemini.walletapp.exception;

public class InsufficientBalanceException extends Throwable {

	private String string;

	public InsufficientBalanceException(String string) {
		// TODO Auto-generated constructor stub
		this.string=string;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
