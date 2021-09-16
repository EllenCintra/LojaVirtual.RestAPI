package com.ellen.loja1.controller.dto;

import java.math.BigDecimal;

import com.ellen.loja1.modelo.Produto;

public class ProdutoDto {

	private Long id; 
	private String nome;
	private BigDecimal preco;
	private String descricao;

	public ProdutoDto() {
		
	}
		
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.descricao = produto.getDescricao();
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

	public String getDescricao() {
		return descricao;
	}
	
	public Produto ofDto(ProdutoDto dto) {
		Produto p = new Produto(dto.nome, dto.preco); 
		return p;
	}

}
