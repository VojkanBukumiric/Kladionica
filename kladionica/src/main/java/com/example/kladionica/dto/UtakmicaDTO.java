package com.example.kladionica.dto;

import java.util.Date;

public class UtakmicaDTO {
	
	private Date datumMec;
	private String domacin;
	private String gost;
	private int tipMec;
	
	public UtakmicaDTO() {
		
	}

	public UtakmicaDTO(Date datumMec, String domacin, String gost, int tipMec) {
		super();
		this.datumMec = datumMec;
		this.domacin = domacin;
		this.gost = gost;
		this.tipMec = tipMec;
	}

	public Date getDatumMec() {
		return datumMec;
	}

	public void setDatumMec(Date datumMec) {
		this.datumMec = datumMec;
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

	public int getTipMec() {
		return tipMec;
	}

	public void setTipMec(int tipMec) {
		this.tipMec = tipMec;
	}

	@Override
	public String toString() {
		return "UtakmicaDTO [datumMec=" + datumMec + ", domacin=" + domacin + ", gost=" + gost + "]";
	}
	
	
		

}
