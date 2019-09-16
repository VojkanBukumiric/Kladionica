package com.example.kladionica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.kladionica.entity.Tipovanje;

@Repository
public interface TipovanjeRepository extends JpaRepository<Tipovanje,Integer> {

	public List<Tipovanje> findByTiketId (int idtiket);

}
