package com.example.kladionica.service;

import java.util.List;

import com.example.kladionica.dto.ListaTiketaDTO;
import com.example.kladionica.dto.TiketDTO;
import com.example.kladionica.entity.Tiket;

public interface TiketService {
	
	public List<Tiket>findAll();
	public Tiket findById(int id);
	public List<ListaTiketaDTO>listaTiketaDTO();
	public Tiket save(Tiket tiket);
	public Tiket update(Tiket tiket);
	public void deleteById(int id);
	public TiketDTO prikaziListic(int id);
	

}
