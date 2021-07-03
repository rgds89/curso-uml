package com.roger.cursomc;

import com.roger.cursomc.domain.*;
import com.roger.cursomc.domain.enums.TipoCliente;
import com.roger.cursomc.repository.*;
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
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

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

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "35148161825", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("1173943674", "1128598390"));

        Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "03021900", cli1, cid1);
        Endereco end2 = new Endereco(null, "Avenida matos", "105", "Sala 800", "Centro", "38777012", cli1, cid3);

        cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(end1, end2));
    }
}
