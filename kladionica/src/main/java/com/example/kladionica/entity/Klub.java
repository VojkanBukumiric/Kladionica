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
@Table(name="klub")
public class Klub {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="naziv")
	private String naziv;
	@Column(name="zemlja")
	private String zemlja;
	
	@OneToMany(mappedBy="domacin")
	private List<Utakmica> tim1;
	
	@OneToMany(mappedBy="gost")
	private List<Utakmica> tim2;

	public Klub() {
	}

	public Klub(int id, String naziv, String zemlja, List<Utakmica> tim1, List<Utakmica> tim2) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.zemlja = zemlja;
		this.tim1 = tim1;
		this.tim2 = tim2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getZemlja() {
		return zemlja;
	}

	public void setZemlja(String zemlja) {
		this.zemlja = zemlja;
	}

	public List<Utakmica> getTim1() {
		return tim1;
	}

	public void setTim1(List<Utakmica> tim1) {
		this.tim1 = tim1;
	}

	public List<Utakmica> getTim2() {
		return tim2;
	}

	public void setTim2(List<Utakmica> tim2) {
		this.tim2 = tim2;
	}

	@Override
	public String toString() {
		return "Klub [id=" + id + ", naziv=" + naziv + ", zemlja=" + zemlja + ", tim1=" + tim1 + ", tim2=" + tim2 + "]";
	}

}
