package com.ellen.loja1.controller.dto;

import java.math.BigDecimal;

import com.ellen.loja1.modelo.Pedido;
import com.ellen.loja1.modelo.Produto;

public class ItemPedidoDto {

	private long id;
	private Pedido pedido;
	private Produto produto;
	private int quantidade;
	
	public long getId() {
		return id;
	}
	public Pedido getPedido() {
		return pedido;
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
