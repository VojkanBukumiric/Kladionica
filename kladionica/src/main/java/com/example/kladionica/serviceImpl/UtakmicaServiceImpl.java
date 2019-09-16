package com.example.kladionica.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kladionica.dto.ListaUtakmicaDTO;
import com.example.kladionica.entity.Utakmica;
import com.example.kladionica.repository.UtakmicaRepository;
import com.example.kladionica.service.UtakmicaService;
@Service
public class UtakmicaServiceImpl implements UtakmicaService {
	
	public UtakmicaRepository utakmicaRepository;
	@Autowired
	public UtakmicaServiceImpl(UtakmicaRepository utakmicaRepository) {
		this.utakmicaRepository = utakmicaRepository;
	}

	@Override
	public List<Utakmica> findAll() {
		
		return utakmicaRepository.findAll();
	}

	@Override
	public void deleteById(int id) {
		utakmicaRepository.deleteById(id);

	}

	@Override
	public Utakmica findById(int id) {
		Optional<Utakmica> mec = utakmicaRepository.findById(id);
		Utakmica utakmica = mec.get();
		return utakmica;
	}

	@Override
	public void save(Utakmica utakmica) {
		utakmicaRepository.save(utakmica);

	}

	@Override
	public Utakmica update(Utakmica utakmica) {
		
		return utakmicaRepository.save(utakmica);
	}

	@Override
	public List<ListaUtakmicaDTO> pronadjiUtakmicePoDatumu(Date datum) {
		Date danasnjiDatum = new Date();
		List<ListaUtakmicaDTO> utakmiceDTO= new ArrayList<ListaUtakmicaDTO>();
		List<Utakmica> utakmice = utakmicaRepository.pronadjiUtakmicePoDatumu(danasnjiDatum);
		for(Utakmica u: utakmice) {
			ListaUtakmicaDTO mec = new ListaUtakmicaDTO();
			mec.setDatum(u.getDatumUtak());
			mec.setDomacin(u.getDomacin().getNaziv());
			mec.setGost(u.getGost().getNaziv());
			mec.setKoeficijent(u.getKvota());
			mec.setId(u.getId());
			utakmiceDTO.add(mec);
			
		}
		return utakmiceDTO;
	}

}
