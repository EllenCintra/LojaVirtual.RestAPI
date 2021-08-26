package com.ellen.loja1.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Pedido pedido;
	@ManyToOne
	private Produto produto;
	public int quantidade = 1;
	public BigDecimal valorTotalItem;
	
	public ItemPedido (Pedido ped, Produto prod) {
		this.pedido = ped;
		this.produto = prod;
		this.valorTotalItem = prod.getPreco();
		pedido.itensPedido.add(this);
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
	
}
