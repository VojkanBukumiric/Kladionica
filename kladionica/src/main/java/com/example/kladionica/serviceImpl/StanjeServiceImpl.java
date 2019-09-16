package com.example.kladionica.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kladionica.entity.Stanje;
import com.example.kladionica.repository.StanjeRepository;
import com.example.kladionica.service.StanjeService;

@Service
public class StanjeServiceImpl implements StanjeService {
	
	public StanjeRepository stanjeRepository;
	@Autowired
	public StanjeServiceImpl(StanjeRepository stanjeRepository) {
		this.stanjeRepository = stanjeRepository;
	}

	@Override
	public List<Stanje> findAll() {
		
		return stanjeRepository.findAll();
	}

	@Override
	public Stanje findById(int id) {
		Optional<Stanje> transakcija = stanjeRepository.findById(id);
		Stanje stanje = transakcija.get();
		return stanje;
	}

	@Override
	public Stanje save(Stanje stanje) {
		
		return stanjeRepository.save(stanje);
	}

	@Override
	public Stanje update(Stanje stanje) {
		
		return stanjeRepository.save(stanje);
	}

	@Override
	public void deleteById(int id) {
		stanjeRepository.deleteById(id);

	}

}
