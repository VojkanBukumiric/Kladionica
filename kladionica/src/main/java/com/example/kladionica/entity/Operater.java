package com.example.kladionica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="operater")
public class Operater {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name="ime")
	private String imeOperatera;
	@Column(name="prezime")
	private String prezimeOperatera;
	@Column(name="lozinka")
	private String password;
	
	public Operater() {
		
	}

	public Operater(int id, String imeOperatera, String prezimeOperatera, String password) {
		super();
		this.id = id;
		this.imeOperatera = imeOperatera;
		this.prezimeOperatera = prezimeOperatera;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImeOperatera() {
		return imeOperatera;
	}

	public void setImeOperatera(String imeOperatera) {
		this.imeOperatera = imeOperatera;
	}

	public String getPrezimeOperatera() {
		return prezimeOperatera;
	}

	public void setPrezimeOperatera(String prezimeOperatera) {
		this.prezimeOperatera = prezimeOperatera;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Operater [id=" + id + ", imeOperatera=" + imeOperatera + ", prezimeOperatera=" + prezimeOperatera
				+ ", password=" + password + "]";
	}

}
