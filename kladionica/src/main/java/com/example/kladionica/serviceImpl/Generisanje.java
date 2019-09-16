package com.example.kladionica.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kladionica.entity.Korisnik;
import com.example.kladionica.entity.Stanje;
import com.example.kladionica.entity.Tiket;
import com.example.kladionica.entity.Tipovanje;
import com.example.kladionica.entity.Utakmica;
import com.example.kladionica.repository.KorisnikRepository;
import com.example.kladionica.repository.StanjeRepository;
import com.example.kladionica.repository.TiketRepository;
import com.example.kladionica.repository.TipovanjeRepository;
import com.example.kladionica.repository.UtakmicaRepository;

@Service
public class Generisanje {
	
	public KorisnikRepository korisnikRepository;
	public UtakmicaRepository utakmicaRepository;
	public TipovanjeRepository tipovanjeRepository;
	public TiketRepository tiketRepository;
	public StanjeRepository stanjeRepository;
	@Autowired
	public Generisanje(KorisnikRepository korisnikRepository, UtakmicaRepository utakmicaRepository,
			TipovanjeRepository tipovanjeRepository, TiketRepository tiketRepository,
			StanjeRepository stanjeRepository) {
		this.korisnikRepository = korisnikRepository;
		this.utakmicaRepository = utakmicaRepository;
		this.tipovanjeRepository = tipovanjeRepository;
		this.tiketRepository = tiketRepository;
		this.stanjeRepository = stanjeRepository;
	}
	
	public Integer odredjivanjeIshodaUtakmica() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(0);
		lista.add(2);
		Random random = new Random();
		return lista.get(random.nextInt(lista.size()));
		
	}
	public void izracunavanjeDobitka(Tiket t, List<Tipovanje>tip) {
		double dobitak = t.getUlog();
		for(Tipovanje tipovanje: tip) {
			dobitak = dobitak*tipovanje.getUtakmica().getKvota();
		}
		t.setDobitak(dobitak);
		Korisnik korisnik = t.getKorisnik();
		double stanje = korisnik.getRacun()+dobitak;
		korisnik.setRacun(stanje);
		korisnikRepository.save(korisnik);
		Date datum = new Date();
		Stanje s = new Stanje();
		s.setDatum(datum);
		s.setSvrha("Dobitan tiket");
		s.setIznos(dobitak);
		stanjeRepository.save(s);
		
		
	}
	
	public void generisanjeTiketa() {
		Integer status = null;
		List<Tiket> tiketi = tiketRepository.findByStatus(status);
		for(Tiket t: tiketi) {
		List<Integer> ishodiUtakmica = new ArrayList<>();
		List<Tipovanje> tipovanje = t.getTipovi();
			for(Tipovanje tip: tipovanje) {
				if((tip.getUtakmica().getIshod()!=null)&&(tip.getUtakmica().getIshod()==tip.getKonacanIshod())) {
					tip.setStatusTipa(1);
					ishodiUtakmica.add(tip.getStatusTipa());
				}
				else if((tip.getUtakmica().getIshod()!=null)&&(tip.getUtakmica().getIshod()==tip.getKonacanIshod())) {
					tip.setStatusTipa(0);
					ishodiUtakmica.add(tip.getStatusTipa());
				}
					else {
						tip.setStatusTipa(status);
					}
				tipovanjeRepository.save(tip);
			}
			if((ishodiUtakmica.size()==tipovanje.size())&&(ishodiUtakmica.contains(0))) {
				t.setStatus(0);
			}
				else if((ishodiUtakmica.size()==tipovanje.size()&&(ishodiUtakmica.contains(0)))) {
					t.setStatus(1);
					izracunavanjeDobitka(t,t.getTipovi());
				}
					else {
						t.setStatus(status);
					}
				tiketRepository.save(t);
		
		}
		
	}
	public void generisanje() {
		Date dan = new Date();
		List<Utakmica>mecevi= utakmicaRepository.findAll();
		for(Utakmica u: mecevi) {
			if((u.getIshod()==null)&&(u.getDatumUtak().before(dan))) {
				u.setIshod(odredjivanjeIshodaUtakmica());
				utakmicaRepository.save(u);
			}
		}
		generisanjeTiketa();
	}
	
	

}
