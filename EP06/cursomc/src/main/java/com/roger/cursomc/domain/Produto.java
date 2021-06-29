package com.roger.cursomc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;

    @Column
    private BigDecimal preco;

    @Column
    private String nome;

    @ManyToMany
    @JoinTable(name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name ="id_produto"),
            inverseJoinColumns= @JoinColumn(name = "id_categoria")
    )
    private List<Categoria> categorias = new ArrayList<>();

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (id_produto != null ? !id_produto.equals(produto.id_produto) : produto.id_produto != null) return false;
        if (preco != null ? !preco.equals(produto.preco) : produto.preco != null) return false;
        if (nome != null ? !nome.equals(produto.nome) : produto.nome != null) return false;
        return categorias != null ? categorias.equals(produto.categorias) : produto.categorias == null;
    }

    @Override
    public int hashCode() {
        int result = id_produto != null ? id_produto.hashCode() : 0;
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (categorias != null ? categorias.hashCode() : 0);
        return result;
    }

    public Produto(){}

    public Produto(Integer id_produto, BigDecimal preco, String nome) {
        this.id_produto = id_produto;
        this.preco = preco;
        this.nome = nome;
    }
}
