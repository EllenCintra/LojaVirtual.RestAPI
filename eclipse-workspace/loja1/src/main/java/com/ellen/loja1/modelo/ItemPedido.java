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
	private int quantidade = 1;
	private BigDecimal valorTotalItem;
	
	public ItemPedido() {
		
	}
	
	public ItemPedido (Pedido ped, Produto prod) {
		this.pedido = ped;
		this.produto = prod;
		this.valorTotalItem = prod.getPreco();
		pedido.itensPedido.add(this);
	}

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
	
	public int setQuantidade(int qtde) {
		return this.quantidade = qtde;
	}

	public BigDecimal getValorTotalItem() {
		return valorTotalItem;
	}	
	
	public void calcularValorItem() {
		this.valorTotalItem = this.getProduto().getPreco()
				.multiply(new BigDecimal(this.quantidade));
	}
}
