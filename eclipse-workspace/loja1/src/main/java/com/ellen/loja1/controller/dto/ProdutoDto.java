package com.ellen.loja1.controller.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ellen.loja1.modelo.Produto;

public class ProdutoDto {

	private Long id;
	@NotNull @NotEmpty
	private String nome;
	@NotNull
	private BigDecimal preco;

	public ProdutoDto() {
		
	}
		
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}

	public Produto ofDto() {
		return new Produto(nome, preco);
	}

}
