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

import com.example.kladionica.dto.ListaTiketaDTO;
import com.example.kladionica.dto.TiketDTO;
import com.example.kladionica.entity.Tiket;
import com.example.kladionica.service.TiketService;

@RestController
@RequestMapping("/")
public class TiketRestController {
	
	public TiketService tiketService;
	@Autowired
	public TiketRestController(TiketService tiketService) {
		this.tiketService = tiketService;
	}
	@GetMapping("/tiketi")
	public List<ListaTiketaDTO> listaTiketaDTO(){
		return	tiketService.listaTiketaDTO();
	}
	@GetMapping("/tiketi/{id}")
	public TiketDTO prikaziListic(@PathVariable int id) {
	return	tiketService.prikaziListic(id);
	}
	@PostMapping("/tiketi")
	public void save(@RequestBody Tiket tiket) {
		tiketService.save(tiket);
	}
	@PutMapping("/tiketi")
	public Tiket update(@RequestBody Tiket tiket) {
		tiketService.save(tiket);
		return tiket;
	}
	@DeleteMapping("tiketi/{id}")
	public void deleteById(@PathVariable int id) {
		tiketService.deleteById(id);
	}
	
	

}
