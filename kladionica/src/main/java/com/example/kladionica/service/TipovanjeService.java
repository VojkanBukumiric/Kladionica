package com.example.kladionica.service;

import java.util.List;

import com.example.kladionica.entity.Tipovanje;

public interface TipovanjeService {
	
	public List<Tipovanje>findAll();
	public Tipovanje findById(int tipovanje);
	public void save (Tipovanje tipovanje) ;
	public void deleteById(int tipovanje);
	public List<Tipovanje> findByTiketId(int id);

}
