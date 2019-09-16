package com.example.kladionica.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kladionica.entity.Klub;
import com.example.kladionica.repository.KlubRepository;
import com.example.kladionica.service.KlubService;
@Service
public class KlubServiceImpl implements KlubService {
	
	public KlubRepository klubRepository;
	@Autowired
	public KlubServiceImpl(KlubRepository klubRepository) {
		
		this.klubRepository = klubRepository;
	}

	@Override
	public List<Klub> findAll() {
		
		return klubRepository.findAll();
	}

	@Override
	public void deleteById(int id) {
		klubRepository.deleteById(id);

	}

	@Override
	public Klub findById(int id) {
		Optional<Klub> ekipa = klubRepository.findById(id);
		Klub klub = ekipa.get();
		return klub;
	}

	@Override
	public void save(Klub klub) {
		klubRepository.save(klub);
	}

	@Override
	public Klub update(Klub klub) {
		
		return klubRepository.save(klub);
	}

}
