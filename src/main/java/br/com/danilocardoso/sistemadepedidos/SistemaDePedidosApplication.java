package br.com.danilocardoso.sistemadepedidos;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.danilocardoso.sistemadepedidos.domain.Categoria;
import br.com.danilocardoso.sistemadepedidos.domain.Cidade;
import br.com.danilocardoso.sistemadepedidos.domain.Cliente;
import br.com.danilocardoso.sistemadepedidos.domain.Endereco;
import br.com.danilocardoso.sistemadepedidos.domain.Estado;
import br.com.danilocardoso.sistemadepedidos.domain.Pagamento;
import br.com.danilocardoso.sistemadepedidos.domain.PagamentoComBoleto;
import br.com.danilocardoso.sistemadepedidos.domain.PagamentoComCartao;
import br.com.danilocardoso.sistemadepedidos.domain.Pedido;
import br.com.danilocardoso.sistemadepedidos.domain.Produto;
import br.com.danilocardoso.sistemadepedidos.domain.enums.EstadoPagamento;
import br.com.danilocardoso.sistemadepedidos.domain.enums.TipoCliente;
import br.com.danilocardoso.sistemadepedidos.repositories.CategoriaRepository;
import br.com.danilocardoso.sistemadepedidos.repositories.CidadeRepository;
import br.com.danilocardoso.sistemadepedidos.repositories.ClienteRepository;
import br.com.danilocardoso.sistemadepedidos.repositories.EnderecoRepository;
import br.com.danilocardoso.sistemadepedidos.repositories.EstadoRepository;
import br.com.danilocardoso.sistemadepedidos.repositories.PagamentoRepository;
import br.com.danilocardoso.sistemadepedidos.repositories.PedidoRepository;
import br.com.danilocardoso.sistemadepedidos.repositories.ProdutoRepository;

@SpringBootApplication
public class SistemaDePedidosApplication implements CommandLineRunner {

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
	
	@Autowired
	private PedidoRepository pedidoRepository; 
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

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

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2020 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("20/07/2020 12:12"), cli1, e2);

		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);

		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("10/06/2020 07:39"),
				null);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
		
	}
}
