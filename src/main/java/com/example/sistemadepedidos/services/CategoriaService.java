package com.example.sistemadepedidos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemadepedidos.domain.Categoria;
import com.example.sistemadepedidos.repositories.CategoryRepository;

@Service 
public class CategoriaService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
		
	}

}
