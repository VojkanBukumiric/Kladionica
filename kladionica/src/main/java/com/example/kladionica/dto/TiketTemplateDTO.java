package com.example.kladionica.dto;

import java.util.Date;

public class TiketTemplateDTO {
	
	private int id;
	private Date datum;
	private double ulogTiketa;
	
	public TiketTemplateDTO() {
		
	}
	public TiketTemplateDTO(int id, Date datum, double ulogTiketa) {
		this.id = id;
		this.datum = datum;
		this.ulogTiketa = ulogTiketa;
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
	public double getUlogTiketa() {
		return ulogTiketa;
	}
	public void setUlogTiketa(double ulogTiketa) {
		this.ulogTiketa = ulogTiketa;
	}
	
	
	
		
	

}
