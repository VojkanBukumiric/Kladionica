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

import com.example.kladionica.entity.Stanje;
import com.example.kladionica.service.StanjeService;

@RestController
@RequestMapping("/")
public class StanjeRestController {
	
	public StanjeService stanjeService;
	@Autowired
	public StanjeRestController(StanjeService stanjeService) {
		
		this.stanjeService = stanjeService;
	}
	@GetMapping("/stanje")
	public List<Stanje>findAll(){
		return stanjeService.findAll();
	}
	@GetMapping("/stanje/{id}")
	public Stanje findById(@PathVariable int id) {
		return stanjeService.findById(id);
	}
	@PostMapping("/stanje")
	public void save(@RequestBody Stanje stanje) {
		stanjeService.save(stanje);
	}
	@PutMapping("/stanje")
	public Stanje update(@RequestBody Stanje stanje) {
		stanjeService.save(stanje);
		return stanje;
	}
	@DeleteMapping("/stanje/{id}")
	public void deleteById(@PathVariable int id) {
		stanjeService.deleteById(id);
	}
	

}
