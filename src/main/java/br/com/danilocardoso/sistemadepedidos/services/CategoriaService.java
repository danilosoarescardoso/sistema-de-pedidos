package br.com.danilocardoso.sistemadepedidos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.danilocardoso.sistemadepedidos.domain.Categoria;
import br.com.danilocardoso.sistemadepedidos.repositories.CategoriaRepository;
import br.com.danilocardoso.sistemadepedidos.services.exceptions.DataIntegrityException;
import javassist.tools.rmi.ObjectNotFoundException;

@Service 
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public List<Categoria> findAll() throws ObjectNotFoundException {
		List<Categoria> obj = repo.findAll();
		return obj;
	}
	
	public String returnCategoryName (Categoria category) {
		return category.getNome();
	}
	
	public Categoria find(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));		
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) throws ObjectNotFoundException {
		this.find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		this.find(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria com produtos");
		}

	}

}
