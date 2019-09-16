package com.example.kladionica.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kladionica.entity.Operater;
import com.example.kladionica.service.OperaterService;

@RestController
@RequestMapping("/")
public class OperaterRestController {
	
	public OperaterService operaterService;
	@Autowired
	public OperaterRestController(OperaterService operaterService) {
		this.operaterService = operaterService;
	}
	
	@GetMapping("/operater")
	public List <Operater> findAll() {
		return operaterService.findAll();	
	}
	
	@PostMapping("/operater")
	public void save(@RequestBody Operater operater) {
		operaterService.save(operater);
	}
	@PutMapping("/operater")
	public Operater update(@RequestBody Operater operater) {
		operaterService.save(operater);
		return operater;
	}
	
	@DeleteMapping("/operater/{id}")
	public void deleteById(@PathVariable int id) {
		operaterService.deleteById(id);
	}
	

}
