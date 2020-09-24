package br.com.danilocardoso.sistemadepedidos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danilocardoso.sistemadepedidos.domain.Pedido;
import br.com.danilocardoso.sistemadepedidos.repositories.PedidoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service 
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Pedido.class.getName()));
		
	}

}
