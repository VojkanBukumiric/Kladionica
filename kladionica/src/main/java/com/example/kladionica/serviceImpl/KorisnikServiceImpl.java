package com.example.kladionica.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.kladionica.dto.IsplataDTO;
import com.example.kladionica.dto.KorisnikDTO;
import com.example.kladionica.dto.TiketTemplateDTO;
import com.example.kladionica.dto.UplataDTO;
import com.example.kladionica.entity.Korisnik;
import com.example.kladionica.entity.Stanje;
import com.example.kladionica.entity.Tiket;
import com.example.kladionica.exception.NedovoljnoNovcaException;
import com.example.kladionica.repository.KorisnikRepository;
import com.example.kladionica.repository.StanjeRepository;
import com.example.kladionica.service.KorisnikService;
@Service
public class KorisnikServiceImpl implements KorisnikService {
	
	public KorisnikRepository korisnikRepository;
	public StanjeRepository stanjeRepository;
	@Autowired
	public KorisnikServiceImpl(KorisnikRepository korisnikRepository, StanjeRepository stanjeRepository) {
		this.korisnikRepository = korisnikRepository;
		this.stanjeRepository = stanjeRepository;
	}

	@Override
	public List<Korisnik> findAll() {
		
		return korisnikRepository.findAll();
	}

	@Override
	public KorisnikDTO findById(int id) {
		Optional<Korisnik> optKorisnik = korisnikRepository.findById(id);
		if(optKorisnik.isPresent()) {
			Korisnik korisnik = optKorisnik.get();
			KorisnikDTO korisnikDTO = new KorisnikDTO(korisnik.getId(),korisnik.getIme(),korisnik.getPrezime(),korisnik.getEmail());
			return korisnikDTO;
		}
		return null;
	}

	@Override
	public List<KorisnikDTO> prikazSvihKorisnika() {
		List<KorisnikDTO> korisnici =new ArrayList<KorisnikDTO>();
		List<Korisnik> listaKorisnika = korisnikRepository.findAll();
		for(Korisnik kor: listaKorisnika) {
			KorisnikDTO korisnikDTO = new KorisnikDTO();
			korisnikDTO.setIme(kor.getIme());
			korisnikDTO.setPrezime(kor.getPrezime());
			korisnikDTO.setEmail(kor.getEmail());
			korisnikDTO.setId(kor.getId());
			korisnici.add(korisnikDTO);
		}
		return korisnici;
	}

	@Override
	public void save(Korisnik korisnik) {
		korisnikRepository.save(korisnik);

	}

	@Override
	public Korisnik update(Korisnik korisnik) {
		
		return korisnikRepository.save(korisnik);
	}

	@Override
	public void deleteById(int id) {
		korisnikRepository.deleteById(id);
	}

	@Override
	public List<KorisnikDTO> pronadjiKorisnikaPoImenu(@RequestBody String ime) {
		List<Korisnik> korisnici=korisnikRepository.pronadjiKorisnikaPoImenu(ime);
		List<KorisnikDTO>korisniciDTO = new ArrayList<>();
		for(Korisnik k: korisnici) {
			KorisnikDTO korisDTO = new KorisnikDTO();
			korisDTO.setId(k.getId());
			korisDTO.setIme(k.getIme());
			korisDTO.setEmail(k.getEmail());
			korisniciDTO.add(korisDTO);
		}
		return korisniciDTO;
		
	}

	@Override
	@Transactional
	public void uplataKorisnika(UplataDTO uplataDTO) {
		Stanje stanje = new Stanje();
		Optional<Korisnik> optionalKorisnik = korisnikRepository.findById(uplataDTO.getIdKorisnik());
		Korisnik korisnik = optionalKorisnik.get();
		korisnik.setRacun(korisnik.getRacun()+uplataDTO.getIznosDobitka());
		stanje.setSvrha("Uspesno je uplaceno na racun: " + uplataDTO.getIznosDobitka());
		stanje.setIznos(uplataDTO.getIznosDobitka());
		korisnikRepository.save(korisnik);
		stanje.setKorisnik(korisnik);
		stanjeRepository.save(stanje);

	}

	@Override
	public void isplataKorisnika(IsplataDTO isplataDTO) {
		Optional<Korisnik>optionalKorisnik = korisnikRepository.findById(isplataDTO.getIdKorisnik());
		Korisnik korisnik = optionalKorisnik.get();
		
		if((korisnik.getRacun()-isplataDTO.getIznos())<0) {
			throw new NedovoljnoNovcaException();
		}
		korisnik.setRacun(korisnik.getRacun()-isplataDTO.getIznos());
		korisnikRepository.save(korisnik);
		Stanje stanje = new Stanje();
		stanje.setIznos(-isplataDTO.getIznos());
		stanje.setSvrha("Uspesno ste dopunili svoj racun");
		stanjeRepository.save(stanje);

	}

	@Override
	public List<TiketTemplateDTO> listiciKorisnika(int id) {
		List<TiketTemplateDTO>listaTiketa = new ArrayList<>();
		Optional<Korisnik>optionalKorisnik = korisnikRepository.findById(id);
		if(optionalKorisnik.isPresent()) {
			Korisnik korisnik = optionalKorisnik.get();
			for(Tiket t: korisnik.getTiket()) {
				TiketTemplateDTO tiketTemplateDTO = new TiketTemplateDTO();
				tiketTemplateDTO.setId(t.getId());
				tiketTemplateDTO.setDatum(t.getDatumTiket());
				tiketTemplateDTO.setUlogTiketa(t.getUlog());
			}
			return listaTiketa;
		}
		return null;
	}

	

}
