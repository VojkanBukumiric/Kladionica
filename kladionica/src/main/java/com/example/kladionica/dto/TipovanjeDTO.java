package com.example.kladionica.dto;

public class TipovanjeDTO {
	
	private int idMec;
	private int tip;
	
	public TipovanjeDTO() {
		
	}
	public TipovanjeDTO(int idMec, int tip) {
		super();
		this.idMec = idMec;
		this.tip = tip;
	}
	public int getIdMec() {
		return idMec;
	}
	public void setIdMec(int idMec) {
		this.idMec = idMec;
	}
	public int getTip() {
		return tip;
	}
	public void setTip(int tip) {
		this.tip = tip;
	}
	
	
	
	

}
