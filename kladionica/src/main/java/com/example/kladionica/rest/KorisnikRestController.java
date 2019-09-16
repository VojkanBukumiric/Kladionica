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

import com.example.kladionica.dto.IsplataDTO;
import com.example.kladionica.dto.KorisnikDTO;
import com.example.kladionica.dto.TiketTemplateDTO;
import com.example.kladionica.dto.UplataDTO;
import com.example.kladionica.entity.Korisnik;
import com.example.kladionica.service.KorisnikService;

@RestController
@RequestMapping("/")
public class KorisnikRestController {
	
	public KorisnikService korisnikService;
	@Autowired
	public KorisnikRestController(KorisnikService korisnikService) {
		this.korisnikService = korisnikService;
	}
	@GetMapping("/korisnici")
	public List<KorisnikDTO>prikazSvihKorisnika(){
		return korisnikService.prikazSvihKorisnika();
	}
	@GetMapping("/korisnici/{id}")
	public KorisnikDTO findById(@PathVariable int id) {
		return korisnikService.findById(id);
	}
	@GetMapping("/korisnik/{id}/tiketi")
	public List<TiketTemplateDTO>listiciKorisnika(@PathVariable int id){
		return korisnikService.listiciKorisnika(id);	
	}
	@GetMapping("/korisnik/ime/{ime}")
	public List<KorisnikDTO>pronadjiKorisnikaPoImenu(@PathVariable String ime){
		return korisnikService.pronadjiKorisnikaPoImenu(ime);
		
	}
	@PostMapping("/korisnik")
	public void save(@RequestBody Korisnik korisnik) {
		 korisnikService.save(korisnik);
	}
	@PostMapping("/korisnik/uplata")
	public void uplataKorisnika(@RequestBody UplataDTO uplataDTO) {
		korisnikService.uplataKorisnika(uplataDTO);
	}
	@PostMapping("/korisnik/isplata")
	public void isplataKorisnika(@RequestBody IsplataDTO isplataDTO) {
		korisnikService.isplataKorisnika(isplataDTO);
	}
	@PutMapping("/korisnici")
	public Korisnik update(@RequestBody Korisnik korisnik) {
		korisnikService.save(korisnik);
		return korisnik;
	}
	@DeleteMapping("/korisnici/{id}")
	public void deleteById(@PathVariable int id) {
		korisnikService.deleteById(id);
	}
	

}
