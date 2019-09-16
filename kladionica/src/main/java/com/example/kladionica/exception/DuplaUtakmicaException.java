package com.example.kladionica.exception;

public class DuplaUtakmicaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 757508327037746195L;

	public DuplaUtakmicaException() {
		super("Ova utakmica je vec na tiketu!");
	}

}
