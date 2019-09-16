package com.example.kladionica.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="korisnik")
public class Korisnik {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="ime")
	private String ime;
	@Column(name="prezime")
	private String prezime;
	@Column(name="email")
	private String email;
	@Column(name="racun")
	private double racun=5;
	
	@OneToMany(mappedBy="korisnik")
	private List<Stanje> stanje;
	
	@OneToMany(mappedBy="korisnik")
	private List<Tiket>tiket;

	public Korisnik() {
		
	}

	public Korisnik(int id, String ime, String prezime, String email, double racun, List<Stanje> stanje,
			List<Tiket> tiket) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.racun = racun;
		this.stanje = stanje;
		this.tiket = tiket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRacun() {
		return racun;
	}

	public void setRacun(double racun) {
		this.racun = racun;
	}

	public List<Stanje> getStanje() {
		return stanje;
	}

	public void setStanje(List<Stanje> stanje) {
		this.stanje = stanje;
	}

	public List<Tiket> getTiket() {
		return tiket;
	}

	public void setTiket(List<Tiket> tiket) {
		this.tiket = tiket;
	}

	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", racun=" + racun
				+ ", stanje=" + stanje + ", tiket=" + tiket + "]";
	}

}
