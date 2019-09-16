package com.example.kladionica.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kladionica.dto.ListaTiketaDTO;
import com.example.kladionica.dto.TiketDTO;
import com.example.kladionica.dto.UtakmicaDTO;
import com.example.kladionica.entity.Korisnik;
import com.example.kladionica.entity.Stanje;
import com.example.kladionica.entity.Tiket;
import com.example.kladionica.entity.Tipovanje;
import com.example.kladionica.entity.Utakmica;
import com.example.kladionica.exception.DuplaUtakmicaException;
import com.example.kladionica.exception.NedovoljnoNovcaException;
import com.example.kladionica.exception.UtakmicaPocelaException;
import com.example.kladionica.repository.KorisnikRepository;
import com.example.kladionica.repository.StanjeRepository;
import com.example.kladionica.repository.TiketRepository;
import com.example.kladionica.repository.TipovanjeRepository;
import com.example.kladionica.repository.UtakmicaRepository;
import com.example.kladionica.service.TiketService;

@Service
public class TiketServiceImpl implements TiketService {
	
	public TiketRepository tiketRepository;
	public UtakmicaRepository utakmicaRepository;
	public KorisnikRepository korisnikRepository;
	public TipovanjeRepository tipovanjeRepository;
	public StanjeRepository stanjeRepository;

	@Autowired
	public TiketServiceImpl(TiketRepository tiketRepository, UtakmicaRepository utakmicaRepository,
			KorisnikRepository korisnikRepository, TipovanjeRepository tipovanjeRepository,
			StanjeRepository stanjeRepository) {
		
		this.tiketRepository = tiketRepository;
		this.utakmicaRepository = utakmicaRepository;
		this.korisnikRepository = korisnikRepository;
		this.tipovanjeRepository = tipovanjeRepository;
		this.stanjeRepository = stanjeRepository;
	}

	@Override
	public List<Tiket> findAll() {
		
		return tiketRepository.findAll();
	}

	@Override
	public Tiket findById(int id) {
		Optional<Tiket> listic =tiketRepository.findById(id);
		Tiket tiket = listic.get();
		return tiket;
	}

	@Override
	public List<ListaTiketaDTO> listaTiketaDTO() {
		List<Tiket>tiketi = tiketRepository.findAll();
		List<ListaTiketaDTO> listaTiketa = new ArrayList<>();
		for(Tiket t: tiketi) {
			ListaTiketaDTO tiketDTO = new ListaTiketaDTO(t.getId(),t.getDatumTiket(),t.getUlog(),t.getKorisnik().getIme());
			listaTiketa.add(tiketDTO);
			
		}
		return listaTiketa;
	}

	@Override
	@Transactional
	public Tiket save(Tiket tiket) {
			int idKorisnik = tiket.getKorisnik().getId();
			Optional<Korisnik> optionalKorisnik = korisnikRepository.findById(idKorisnik);
			Korisnik korisnik = optionalKorisnik.get();
			if((korisnik.getRacun()-tiket.getUlog())<0) {
				tiketRepository.save(null);
				throw new NedovoljnoNovcaException();
			} else {
				List<Tipovanje> tip = tiket.getTipovi();
				List<Tipovanje> listaKladjenja = new ArrayList<Tipovanje>();
				List<Integer> utakmice = new ArrayList<>();
				Date datum = new Date();
				for(Tipovanje t: tip) {
					Tipovanje tipovanje = new Tipovanje();
					Optional<Utakmica> optionalUtakmica= utakmicaRepository.findById(t.getUtakmica().getId());
					Utakmica utakmica = optionalUtakmica.get();
					if(utakmice.contains(utakmica.getId())) {
						throw new DuplaUtakmicaException();
					}
					
					if(utakmica.getDatumUtak().before(datum)) {
						throw new UtakmicaPocelaException();
					}
					utakmice.add(utakmica.getId());
					tipovanje.setTiket(tiket);
					tipovanje.setUtakmica(utakmica);
					tipovanje.setKonacanIshod(t.getKonacanIshod());
					tipovanjeRepository.save(tipovanje);
					listaKladjenja.add(tipovanje);				
				}
				double saldo = korisnik.getRacun()-tiket.getUlog();
				korisnik.setRacun(saldo);
				korisnikRepository.save(korisnik);
				tiket.setKorisnik(korisnik);
				tiketRepository.save(tiket);
				
				Stanje stanje= new Stanje();
				stanje.setIznos(-tiket.getUlog());
				stanje.setKorisnik(korisnik);
				stanje.setSvrha("Uplata tiketa");
				stanjeRepository.save(stanje);
				
				
			}
		
		return null;
	}

	@Override
	public Tiket update(Tiket tiket) {
		
		return tiketRepository.save(tiket);
	}

	@Override
	public void deleteById(int id) {
		tiketRepository.deleteById(id);

	}

	@Override
	public TiketDTO prikaziListic(int id) {
		Optional<Tiket> tiketi = tiketRepository.findById(id);
		if(tiketi.isPresent()) {
			Tiket tiket = tiketi.get();
			List<Tipovanje> tipoviUtakmica = tipovanjeRepository.findByTiketId(id);
			List<UtakmicaDTO> utakmice = new ArrayList<>();
			for(Tipovanje t: tipoviUtakmica) {
				UtakmicaDTO utakmicaDTO = new UtakmicaDTO();
				utakmicaDTO.setDatumMec(t.getUtakmica().getDatumUtak());
				utakmicaDTO.setDomacin(t.getUtakmica().getDomacin().getNaziv());
				utakmicaDTO.setGost(t.getUtakmica().getGost().getNaziv());
				utakmicaDTO.setTipMec(t.getKonacanIshod());
				
				utakmice.add(utakmicaDTO);				
				
			}
			TiketDTO tik = new TiketDTO();
			tik.setDatumTiket(tiket.getDatumTiket());
			tik.setIdTiket(id);
			tik.setUtakmice(utakmice);
			tik.setUlog(tik.getUlog());
			
			return tik;
			
		}
		return null;
	}

}
