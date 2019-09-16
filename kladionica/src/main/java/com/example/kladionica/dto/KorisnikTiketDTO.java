package com.example.kladionica.dto;

import java.util.List;

public class KorisnikTiketDTO {
	private int id;
	private List<TiketTemplateDTO> tiket;
	public KorisnikTiketDTO() {
		
	}
	public KorisnikTiketDTO(int id, List<TiketTemplateDTO> tiket) {
		super();
		this.id = id;
		this.tiket = tiket;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<TiketTemplateDTO> getTiket() {
		return tiket;
	}
	public void setTiket(List<TiketTemplateDTO> tiket) {
		this.tiket = tiket;
	}
	
	
	

}
