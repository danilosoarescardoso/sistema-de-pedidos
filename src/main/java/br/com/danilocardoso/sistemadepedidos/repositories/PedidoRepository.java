package br.com.danilocardoso.sistemadepedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.danilocardoso.sistemadepedidos.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido , Integer>{
	
}
