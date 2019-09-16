package com.example.kladionica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.kladionica.entity.Operater;

@Repository
public interface OperaterRepository extends JpaRepository<Operater,Integer> {

}
