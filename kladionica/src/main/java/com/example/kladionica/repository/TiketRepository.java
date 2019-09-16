package com.example.kladionica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.kladionica.entity.Tiket;

@Repository
public interface TiketRepository extends JpaRepository<Tiket,Integer> {

	List<Tiket> findByStatus(Integer status);

}
