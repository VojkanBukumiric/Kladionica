package com.example.kladionica.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kladionica.entity.Operater;
import com.example.kladionica.repository.OperaterRepository;
import com.example.kladionica.service.OperaterService;

@Service
public class OperaterServiceImpl implements OperaterService {
	
	public OperaterRepository operaterRepository;
	@Autowired
	public OperaterServiceImpl(OperaterRepository operaterRepository) {
		this.operaterRepository = operaterRepository;
	}

	@Override
	public List<Operater> findAll() {
		
		return operaterRepository.findAll();
	}

	@Override
	public void save(Operater operater) {
		
		operaterRepository.save(operater);
	}

	@Override
	public Operater update(Operater operater) {
		
		return operaterRepository.save(operater);
	}

	@Override
	public void deleteById(int id) {
		
		operaterRepository.deleteById(id);
	}

}
