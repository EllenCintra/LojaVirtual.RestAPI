package com.ellen.loja1.controller.dto;

import java.math.BigDecimal;

import com.ellen.loja1.modelo.ItemPedido;
import com.ellen.loja1.modelo.Produto;

public class ItemPedidoDto {

	private long id;
	private Produto produto;
	private int quantidade;
	
	public ItemPedidoDto(ItemPedido itemPedido) {
		this.id = itemPedido.getId();
		this.produto = itemPedido.getProduto();
		this.quantidade = itemPedido.getQuantidade();
	}
	
	public long getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public BigDecimal getValorTotalItem() {
		return valorTotalItem;
	}
	private BigDecimal valorTotalItem;
}
