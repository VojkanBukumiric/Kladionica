package com.example.kladionica.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kladionica.entity.Tiket;
import com.example.kladionica.entity.Tipovanje;
import com.example.kladionica.repository.TipovanjeRepository;
import com.example.kladionica.service.TipovanjeService;

@Service
public class TipovanjeServiceImpl implements TipovanjeService {
	
	public TipovanjeRepository tipovanjeRepository;
	@Autowired
	public TipovanjeServiceImpl(TipovanjeRepository tipovanjeRepository) {
		this.tipovanjeRepository = tipovanjeRepository;
	}

	@Override
	public List<Tipovanje> findAll() {
		
		return tipovanjeRepository.findAll();
	}

	@Override
	public Tipovanje findById(int id) {
		Optional<Tipovanje> tipovi = tipovanjeRepository.findById(id);
		Tipovanje tipovanje = tipovi.get();
		
		return tipovanje;
	}

	@Override
	public void save(Tipovanje tipovanje) {
		tipovanjeRepository.save(tipovanje);

	}

	@Override
	public void deleteById(int id) {
		tipovanjeRepository.deleteById(id);
		
	}

	@Override
	public List<Tipovanje> findByTiketId(int idtiket) {
		List<Tipovanje> tip = tipovanjeRepository.findByTiketId(idtiket);
		return tip;
	}

}
