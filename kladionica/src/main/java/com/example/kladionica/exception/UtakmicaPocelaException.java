package com.example.kladionica.exception;

public class UtakmicaPocelaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8734712701546112059L;

	public UtakmicaPocelaException() {
		super("Utakmica je vec pocela,nije moguce odigrati !");
	}

}
