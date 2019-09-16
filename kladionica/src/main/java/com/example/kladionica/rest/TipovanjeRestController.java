package com.example.kladionica.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kladionica.entity.Tipovanje;
import com.example.kladionica.service.TipovanjeService;

@RestController
@RequestMapping("/")
public class TipovanjeRestController {
	
	public TipovanjeService tipovanjeService;
	@Autowired
	public TipovanjeRestController(TipovanjeService tipovanjeService) {
		this.tipovanjeService = tipovanjeService;
	}
	@GetMapping("/tipovanje")
	public List<Tipovanje>findAll(){
		return tipovanjeService.findAll();
	}
	@GetMapping("/tipovanje/{id}")
	public Tipovanje findById(@PathVariable int id) {
		return tipovanjeService.findById(id);
	}
	@PostMapping("/tipovanje")
	public void save(@RequestBody Tipovanje tipovanje) {
		tipovanjeService.save(tipovanje);
	}
	@DeleteMapping("/tipovanje/{id}")
	public void deleteById(@PathVariable int id) {
		tipovanjeService.deleteById(id);
	}
	
	

}
