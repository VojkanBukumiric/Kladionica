package com.example.kladionica.exception;

public class NedovoljnoNovcaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4451179697286479997L;

	public NedovoljnoNovcaException() {
		super("Nemate dovoljno novca na racunu. Vas tiket nije uplacen ");
	}

}
