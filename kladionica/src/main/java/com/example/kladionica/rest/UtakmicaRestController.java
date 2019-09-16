package com.example.kladionica.rest;

import java.util.Date;
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

import com.example.kladionica.dto.ListaUtakmicaDTO;
import com.example.kladionica.entity.Utakmica;
import com.example.kladionica.service.UtakmicaService;
@RestController
@RequestMapping("/")
public class UtakmicaRestController {
	
	public UtakmicaService utakmicaService;
	@Autowired
	public UtakmicaRestController(UtakmicaService utakmicaService) {
		this.utakmicaService = utakmicaService;
	}
	@GetMapping("/utakmice")
	public List<Utakmica>findAll(){
		return utakmicaService.findAll();
	}
	@GetMapping("/utakmice/{id}")
	public Utakmica findById(@PathVariable int id) {
		return utakmicaService.findById(id);
	}
	@GetMapping("/mecevi")
	public List<ListaUtakmicaDTO>pronadjiUtakmicePoDatumu(Date datum){
		return utakmicaService.pronadjiUtakmicePoDatumu(datum);
	}
	@PostMapping("/utakmice")
	public void save(@RequestBody Utakmica utakmica) {
		 utakmicaService.save(utakmica);
	}
	@PutMapping("utakmice/")
	public Utakmica update(@RequestBody Utakmica utakmica) {
		utakmicaService.save(utakmica);
		return utakmica;
	}
	@DeleteMapping("/utakmice/{id}")
	public void deleteById(@PathVariable int id) {
		utakmicaService.deleteById(id);
	}
	

}
