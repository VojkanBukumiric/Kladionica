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

import com.example.kladionica.entity.Klub;
import com.example.kladionica.service.KlubService;

@RestController
@RequestMapping("/")
public class KlubRestController {
	
	public KlubService klubService;
	@Autowired
	public KlubRestController(KlubService klubService) {
		this.klubService = klubService;
	}
	
	@GetMapping("/klubovi")
	public List<Klub>findAll(){
		return klubService.findAll();
	}
	@GetMapping("/klubovi/{id}")
	public Klub findById(@PathVariable int id) {
		return klubService.findById(id);
	}
	@PostMapping("/klubovi")
	public void save(@RequestBody Klub klub) {
		klubService.save(klub);
	}
	@PutMapping("/klubovi")
	public Klub update(@RequestBody Klub klub) {
		klubService.save(klub);	
		return klub;
	}
	@DeleteMapping("/klubovi/{id}")
	public void deleteById(@PathVariable int id) {
		klubService.deleteById(id);
	}
	
	
	

}
