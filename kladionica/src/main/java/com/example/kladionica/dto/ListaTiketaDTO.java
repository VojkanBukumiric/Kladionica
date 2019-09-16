package com.example.kladionica.dto;

import java.util.Date;

public class ListaTiketaDTO {
	
	private int idTiket;
	private Date datumTiketa;
	private double ulogTiketa;
	private String imeKorisnika;
	
	public ListaTiketaDTO() {
	}

	public ListaTiketaDTO(int idTiket, Date datumTiketa, double ulogTiketa, String imeKorisnika) {
		super();
		this.idTiket = idTiket;
		this.datumTiketa = datumTiketa;
		this.ulogTiketa = ulogTiketa;
		this.imeKorisnika = imeKorisnika;
	}

	public int getIdTiket() {
		return idTiket;
	}

	public void setIdTiket(int idTiket) {
		this.idTiket = idTiket;
	}

	public Date getDatumTiketa() {
		return datumTiketa;
	}

	public void setDatumTiketa(Date datumTiketa) {
		this.datumTiketa = datumTiketa;
	}

	public double getUlogTiketa() {
		return ulogTiketa;
	}

	public void setUlogTiketa(double ulogTiketa) {
		this.ulogTiketa = ulogTiketa;
	}

	public String getImeKorisnika() {
		return imeKorisnika;
	}

	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}
	
	
	

}
