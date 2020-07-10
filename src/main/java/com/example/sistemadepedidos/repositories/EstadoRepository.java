package com.example.sistemadepedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistemadepedidos.domain.Estado;
import com.example.sistemadepedidos.domain.Produto;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	
}
