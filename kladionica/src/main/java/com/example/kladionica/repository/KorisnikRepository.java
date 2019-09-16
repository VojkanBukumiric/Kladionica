package com.example.kladionica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.kladionica.entity.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Integer> {

	List<Korisnik> pronadjiKorisnikaPoImenu(String ime);

}
