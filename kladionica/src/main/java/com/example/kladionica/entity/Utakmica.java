package com.example.kladionica.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utakmica")
public class Utakmica {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="datumUtakmice")
	private Date datumUtak;
	private double kvota= 1.5;
	private Integer ishod = null;
	
	@ManyToOne
	@JoinColumn(name="iddomacin")
	private Klub domacin;
	
	@ManyToOne
	@JoinColumn(name="idgost")
	private Klub gost;
	
	@OneToMany(mappedBy="utakmica")
	private List<Tipovanje> tipovi;

	public Utakmica() {
	}

	public Utakmica(int id, Date datumUtak, double kvota, Integer ishod, Klub domacin, Klub gost,
			List<Tipovanje> tipovi) {
		super();
		this.id = id;
		this.datumUtak = datumUtak;
		this.kvota = kvota;
		this.ishod = ishod;
		this.domacin = domacin;
		this.gost = gost;
		this.tipovi = tipovi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatumUtak() {
		return datumUtak;
	}

	public void setDatumUtak(Date datumUtak) {
		this.datumUtak = datumUtak;
	}

	public double getKvota() {
		return kvota;
	}

	public void setKvota(double kvota) {
		this.kvota = kvota;
	}

	public Integer getIshod() {
		return ishod;
	}

	public void setIshod(Integer ishod) {
		this.ishod = ishod;
	}

	public Klub getDomacin() {
		return domacin;
	}

	public void setDomacin(Klub domacin) {
		this.domacin = domacin;
	}

	public Klub getGost() {
		return gost;
	}

	public void setGost(Klub gost) {
		this.gost = gost;
	}

	public List<Tipovanje> getTipovi() {
		return tipovi;
	}

	public void setTipovi(List<Tipovanje> tipovi) {
		this.tipovi = tipovi;
	}

	@Override
	public String toString() {
		return "Utakmica [id=" + id + ", datumUtak=" + datumUtak + ", kvota=" + kvota + ", ishod=" + ishod
				+ ", domacin=" + domacin + ", gost=" + gost + ", tipovi=" + tipovi + "]";
	}

}
