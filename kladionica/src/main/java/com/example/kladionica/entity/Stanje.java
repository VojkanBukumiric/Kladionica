package com.example.kladionica.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stanje")
public class Stanje {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="datum")
	private Date datum = new Date();
	@Column(name="svrha")
	private String svrha;
	@Column(name="iznos")
	private double iznos;
	
	@ManyToOne
	@JoinColumn(name="idkorisnik")
	private Korisnik korisnik;

	public Stanje() {
		
	}

	public Stanje(int id, Date datum, String svrha, double iznos, Korisnik korisnik) {
		super();
		this.id = id;
		this.datum = datum;
		this.svrha = svrha;
		this.iznos = iznos;
		this.korisnik = korisnik;
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

	public String getSvrha() {
		return svrha;
	}

	public void setSvrha(String svrha) {
		this.svrha = svrha;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	@Override
	public String toString() {
		return "Stanje [id=" + id + ", datum=" + datum + ", svrha=" + svrha + ", iznos=" + iznos + ", korisnik="
				+ korisnik + "]";
	}

}
