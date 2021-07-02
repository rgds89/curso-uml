package com.roger.cursomc;

import com.roger.cursomc.domain.Categoria;
import com.roger.cursomc.domain.Cidade;
import com.roger.cursomc.domain.Estado;
import com.roger.cursomc.domain.Produto;
import com.roger.cursomc.repository.CategoriaRepository;
import com.roger.cursomc.repository.CidadeRepository;
import com.roger.cursomc.repository.EstadoRepository;
import com.roger.cursomc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class CursosMcApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursosMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null, new BigDecimal("2000"), "Computador");
		Produto p2 = new Produto(null, new BigDecimal("800"), "Impressora");
		Produto p3 = new Produto(null, new BigDecimal("80"), "Mouse");

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade cid1 = new Cidade(null, "Campinas", est2);
		Cidade cid2 = new Cidade(null, "Belo Horizonte", est1);
		Cidade cid3 = new Cidade(null, "São Paulo", est2);


		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().add(p2);

		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);

		est1.getCidades().addAll(Arrays.asList(cid2));
		est2.getCidades().addAll(Arrays.asList(cid1, cid3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));


	}
}
