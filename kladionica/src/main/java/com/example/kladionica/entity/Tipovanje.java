package com.example.kladionica.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tipovanje")
public class Tipovanje {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int konacanIshod;
	private Integer statusTipa = null;
	@ManyToOne
	@JoinColumn(name = "idutakmica")
	private Utakmica utakmica;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idtiket")
	private Tiket tiket;
	
	public Tipovanje() {
	}

	public Tipovanje(int id, int konacanIshod, Utakmica utakmica, Tiket tiket) {
		super();
		this.id = id;
		this.konacanIshod = konacanIshod;
		this.utakmica = utakmica;
		this.tiket = tiket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKonacanIshod() {
		return konacanIshod;
	}

	public void setKonacanIshod(int konacanIshod) {
		this.konacanIshod = konacanIshod;
	}

	public Integer getStatusTipa() {
		return statusTipa;
	}

	public void setStatusTipa(Integer statusTipa) {
		this.statusTipa = statusTipa;
	}

	public Utakmica getUtakmica() {
		return utakmica;
	}

	public void setUtakmica(Utakmica utakmica) {
		this.utakmica = utakmica;
	}

	public Tiket getTiket() {
		return tiket;
	}

	public void setTiket(Tiket tiket) {
		this.tiket = tiket;
	}

	@Override
	public String toString() {
		return "Tipovanje [id=" + id + ", konacanIshod=" + konacanIshod + ", statusTipa=" + statusTipa + ", utakmica="
				+ utakmica + ", tiket=" + tiket + "]";
	}
	
}
