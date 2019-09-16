package com.example.kladionica.service;

import java.util.List;

import com.example.kladionica.dto.IsplataDTO;
import com.example.kladionica.dto.KorisnikDTO;
import com.example.kladionica.dto.TiketDTO;
import com.example.kladionica.dto.TiketTemplateDTO;
import com.example.kladionica.dto.UplataDTO;
import com.example.kladionica.entity.Korisnik;

public interface KorisnikService {
	
	public List<Korisnik> findAll();
	public KorisnikDTO findById(int id);
	public List<KorisnikDTO> prikazSvihKorisnika();
	public void save (Korisnik korisnik);
	public Korisnik update (Korisnik korisnik);
	public void deleteById(int id);
	public List<KorisnikDTO> pronadjiKorisnikaPoImenu(String ime);
	public void uplataKorisnika (UplataDTO uplataDTO);
	public void isplataKorisnika (IsplataDTO isplataDTO);
	public List<TiketTemplateDTO>listiciKorisnika(int id);
}
