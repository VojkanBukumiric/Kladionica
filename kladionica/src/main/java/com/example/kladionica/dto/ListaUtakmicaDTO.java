package com.example.kladionica.dto;

import java.util.Date;

public class ListaUtakmicaDTO {
	
	private int id;
	private Date datum;
	private String domacin;
	private String gost;
	private double koeficijent;
	
	public ListaUtakmicaDTO() {
		
	}

	public ListaUtakmicaDTO(int id, Date datum, String domacin, String gost, double koeficijent) {
		super();
		this.id = id;
		this.datum = datum;
		this.domacin = domacin;
		this.gost = gost;
		this.koeficijent = koeficijent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getDomacin() {
		return domacin;
	}

	public void setDomacin(String domacin) {
		this.domacin = domacin;
	}

	public String getGost() {
		return gost;
	}

	public void setGost(String gost) {
		this.gost = gost;
	}

	public double getKoeficijent() {
		return koeficijent;
	}

	public void setKoeficijent(double koeficijent) {
		this.koeficijent = koeficijent;
	}

	@Override
	public String toString() {
		return "ListaUtakmicaDTO [id=" + id + ", datum=" + datum + ", domacin=" + domacin + ", gost=" + gost
				+ ", koeficijent=" + koeficijent + "]";
	}
	
	
	

}
