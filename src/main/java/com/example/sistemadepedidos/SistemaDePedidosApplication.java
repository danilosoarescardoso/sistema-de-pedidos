package com.example.sistemadepedidos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sistemadepedidos.domain.Categoria;
import com.example.sistemadepedidos.domain.Cidade;
import com.example.sistemadepedidos.domain.Cliente;
import com.example.sistemadepedidos.domain.Endereco;
import com.example.sistemadepedidos.domain.Estado;
import com.example.sistemadepedidos.domain.Produto;
import com.example.sistemadepedidos.domain.enums.TipoCliente;
import com.example.sistemadepedidos.repositories.CategoriaRepository;
import com.example.sistemadepedidos.repositories.CidadeRepository;
import com.example.sistemadepedidos.repositories.ClienteRepository;
import com.example.sistemadepedidos.repositories.EnderecoRepository;
import com.example.sistemadepedidos.repositories.EstadoRepository;
import com.example.sistemadepedidos.repositories.ProdutoRepository;

@SpringBootApplication
public class SistemaDePedidosApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecorepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaDePedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 5000.00);
		Produto p3 = new Produto(null, "celular", 8000.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
			
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "37341695005", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27859090", "12958101"));
		Endereco e1 = new Endereco(null, "Rua Mato Grosso", "123", "Casa 2", "Centro", "13238250", cli1, c1);
		Endereco e2 = new Endereco(null, "Chacára Azul", "555", "Sala 1", "Bairro Zoneado", "45010180", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecorepository.saveAll(Arrays.asList(e1, e2));
		
		
	}
	
	

}
