package com.example.kladionica.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.kladionica.entity.Utakmica;

@Repository
public interface UtakmicaRepository extends JpaRepository<Utakmica,Integer> {

	List<Utakmica> pronadjiUtakmicePoDatumu(Date danasnjiDatum);

}
