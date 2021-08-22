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
	
	 public ItemPedido (Pedido ped, Produto prod) {
		this.pedido = ped;
		this.produto = prod;
		calcularValorItem();
	}
	
	private void calcularValorItem() {
		this.valorTotalItem = this.produto.getPreco().multiply(new BigDecimal(quantidade));
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
		calcularValorItem();
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		calcularValorItem();
	}

	public BigDecimal getValorTotalItem() {
		return valorTotalItem;
	}
	
	
	
}
