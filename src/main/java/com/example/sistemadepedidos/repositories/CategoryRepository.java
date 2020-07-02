package com.example.sistemadepedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistemadepedidos.domain.Categoria;

@Repository
public interface CategoryRepository extends JpaRepository<Categoria, Integer>{
	
}
