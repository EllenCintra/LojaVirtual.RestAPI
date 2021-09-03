package br.com.ellen.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ItemPedido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorPorItem() {
		return valorPorItem;
	}

	public void setValorPorItem(BigDecimal valorPorItem) {
		this.valorPorItem = valorPorItem;
	}

	@ManyToMany
	private Pedido pedido;
	
	@ManyToMany
	private Produto produto;
	
	private int quantidade;
	
	private BigDecimal valorPorItem;
	
	public ItemPedido (Pedido pedido, Produto produto, int qtde) {
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = qtde;
		this.valorPorItem = produto.getPreco().multiply(new BigDecimal(qtde));
	}
}
