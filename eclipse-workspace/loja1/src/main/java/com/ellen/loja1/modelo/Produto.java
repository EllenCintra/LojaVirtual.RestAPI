package com.ellen.loja1.modelo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ellen.loja1.controller.dto.ProdutoDto;

@Entity
public class Produto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull @NotEmpty
	private String nome;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Categoria categoria;
	private String descricao;
	@NotNull
	private BigDecimal preco;
	
	public Produto() {
		
	}
	
	public Produto(String nome, BigDecimal preco, Categoria categoria, String descricao) {
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public long getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public ProdutoDto toDto () {
		return new ProdutoDto(this);
	}

}
