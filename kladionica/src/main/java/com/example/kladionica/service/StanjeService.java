package com.example.kladionica.service;

import java.util.List;

import com.example.kladionica.entity.Stanje;

public interface StanjeService {
	
	public List<Stanje>findAll();
	public Stanje findById(int id);
	public Stanje save(Stanje stanje);
	public Stanje update(Stanje stanje);
	public void deleteById(int id);

}
