package com.example.kladionica.dto;

import java.util.Date;
import java.util.List;

public class TiketDTO {
	
	private int idTiket;
	private Date datumTiket;
	private List<UtakmicaDTO> utakmice;
	private double ulog;
	
	public TiketDTO() {
	
	}

	public TiketDTO(int idTiket, Date datumTiket, List<UtakmicaDTO> utakmice, double ulog) {
		super();
		this.idTiket = idTiket;
		this.datumTiket = datumTiket;
		this.utakmice = utakmice;
		this.ulog = ulog;
	}

	public int getIdTiket() {
		return idTiket;
	}

	public void setIdTiket(int idTiket) {
		this.idTiket = idTiket;
	}

	public Date getDatumTiket() {
		return datumTiket;
	}

	public void setDatumTiket(Date datumTiket) {
		this.datumTiket = datumTiket;
	}

	public List<UtakmicaDTO> getUtakmice() {
		return utakmice;
	}

	public void setUtakmice(List<UtakmicaDTO> utakmice) {
		this.utakmice = utakmice;
	}

	public double getUlog() {
		return ulog;
	}

	public void setUlog(double ulog) {
		this.ulog = ulog;
	}
	

	

}
