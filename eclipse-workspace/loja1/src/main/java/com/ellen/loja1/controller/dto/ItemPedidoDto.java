package com.ellen.loja1.controller.dto;

import java.math.BigDecimal;

import com.ellen.loja1.modelo.ItemPedido;

public class ItemPedidoDto {

	private long id;
	private ProdutoDto produto;
	private int quantidade;
	private BigDecimal valorTotalItem;
	
	public ItemPedidoDto(ItemPedido itemPedido) {
		this.id = itemPedido.getId();
		this.produto = itemPedido.getProduto().toDto();
		this.quantidade = itemPedido.getQuantidade();
		this.valorTotalItem = itemPedido.getValorTotalItem();
	}
	
	public long getId() {
		return id;
	}

	public ProdutoDto getProduto() {
		return produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public BigDecimal getValorTotalItem() {
		return valorTotalItem;
	}
	
}
