package com.example.kladionica.service;

import java.util.List;

import com.example.kladionica.entity.Operater;

public interface OperaterService {
	
	public List<Operater>findAll();
	public void save(Operater operater);
	public Operater update(Operater operater);
	public void deleteById(int id);

}
