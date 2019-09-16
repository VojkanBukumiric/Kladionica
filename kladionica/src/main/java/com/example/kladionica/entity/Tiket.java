package com.example.kladionica.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tiket")
public class Tiket {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "datumTiket")
	private Date datumTiket = new Date();
	private double ulog;
	private double dobitak = 0;
	@ManyToOne
	@JoinColumn(name = "idkorisnik")
	private Korisnik korisnik;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "tiket")
	private List<Tipovanje> tipovi;
	private Integer status = null;
	
	public Tiket() {
		
	}

	public Tiket(int id, Date datumTiket, double ulog, double dobitak, Korisnik korisnik, List<Tipovanje> tipovi) {
		super();
		this.id = id;
		this.datumTiket = datumTiket;
		this.ulog = ulog;
		this.dobitak = dobitak;
		this.korisnik = korisnik;
		this.tipovi = tipovi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatumTiket() {
		return datumTiket;
	}

	public void setDatumTiket(Date datumTiket) {
		this.datumTiket = datumTiket;
	}

	public double getUlog() {
		return ulog;
	}

	public void setUlog(double ulog) {
		this.ulog = ulog;
	}

	public double getDobitak() {
		return dobitak;
	}

	public void setDobitak(double dobitak) {
		this.dobitak = dobitak;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Tipovanje> getTipovi() {
		return tipovi;
	}

	public void setTipovi(List<Tipovanje> tipovi) {
		this.tipovi = tipovi;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Tiket [id=" + id + ", datumTiket=" + datumTiket + ", ulog=" + ulog + ", dobitak=" + dobitak
				+ ", korisnik=" + korisnik + ", tipovi=" + tipovi + ", status=" + status + "]";
	}
	
	
}
