package com.example.kladionica.dto;

public class IsplataDTO {
	
	private int idKorisnik;
	private double iznos;
	
	public IsplataDTO() {
		
	}

	public IsplataDTO(int idKorisnik, double iznos) {
		this.idKorisnik = idKorisnik;
		this.iznos = iznos;
	}

	public int getIdKorisnik() {
		return idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	

	

}
