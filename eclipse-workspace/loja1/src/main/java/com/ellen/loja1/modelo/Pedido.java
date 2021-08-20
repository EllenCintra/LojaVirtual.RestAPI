package com.ellen.loja1.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Cliente cliente;
	@OneToMany (mappedBy = "pedido", cascade = CascadeType.ALL)//mappedBy pq é um relacionamento bidirecional, ou seja, tbm está definido na entidade ItemPedido. Se não incluir o "mapped by) é criada uma outra tabela para este relacionamento
	private List<ItemPedido> itensPedido = new ArrayList<>();
	private LocalDate dataPedido;
	private BigDecimal valorPedido;
	
	public Pedido (Cliente cliente, LocalDate data) {
		this.cliente = cliente;
		this.dataPedido = data;
	}
	
	public void adicionarItemAoPedido (Produto p, int quantidade) {
		ItemPedido itemPedido = new ItemPedido (this, p, quantidade);
		this.itensPedido.add(itemPedido);
		this.valorPedido.add(itemPedido.getValorTotalItem());
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemPedido> getItensPedido() {
		return this.itensPedido;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
}
