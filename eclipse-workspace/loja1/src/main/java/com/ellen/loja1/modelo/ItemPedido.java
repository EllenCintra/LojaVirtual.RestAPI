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
	private int quantidade;
	private BigDecimal valorTotalItem;
	
	 ItemPedido (Pedido ped, Produto prod, int qtde ) {
		this.pedido = ped;
		this.produto = prod;
		this.quantidade = qtde;
		calcularValorItem(this.produto, this.quantidade);
	}
	
	private void calcularValorItem(Produto produto2, int quantidade2) {
		this.valorTotalItem = produto2.getPreco().multiply(new BigDecimal (quantidade2));
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
		this.valorTotalItem = produto.getPreco().multiply(new BigDecimal (this.quantidade));
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		this.valorTotalItem = this.produto.getPreco().multiply(new BigDecimal (quantidade));
	}

	public BigDecimal getValorTotalItem() {
		return valorTotalItem;
	}
	
	
	
}
