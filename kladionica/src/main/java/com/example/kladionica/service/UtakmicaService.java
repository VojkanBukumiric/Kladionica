package com.example.kladionica.service;

import java.util.Date;
import java.util.List;

import com.example.kladionica.dto.ListaUtakmicaDTO;
import com.example.kladionica.entity.Klub;
import com.example.kladionica.entity.Utakmica;

public interface UtakmicaService {
	
	public List<Utakmica>findAll();
	public void deleteById(int id);
	public Utakmica findById(int id);
	public void save(Utakmica utakmica);
	public Utakmica update(Utakmica utakmica);
	public List<ListaUtakmicaDTO> pronadjiUtakmicePoDatumu(Date datum);
	

}
