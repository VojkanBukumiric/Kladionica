package com.example.kladionica.service;

import java.util.List;

import com.example.kladionica.entity.Klub;

public interface KlubService {
	
	public List<Klub> findAll();
	public void deleteById(int id);
	public Klub findById(int id);
	public void save(Klub klub);
	public Klub update(Klub klub);

}
