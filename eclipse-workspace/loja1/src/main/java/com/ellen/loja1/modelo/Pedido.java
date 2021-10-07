package com.ellen.loja1.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Cliente cliente;


	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) // mappedBy pq é um relacionamento bidirecional, ou seja,
																// tbm está definido na entidade ItemPedido. Se não
																// incluir o "mapped by) é criada uma outra tabela para
																// este relacionamento
	List<ItemPedido> itensPedido = new ArrayList<>();
	private LocalDate dataPedido = LocalDate.now();
	private BigDecimal valorPedido = BigDecimal.ZERO;
	@Enumerated(EnumType.STRING)
	private StatusPedido status = StatusPedido.EM_ABERTO;
	
	public Pedido() {
		
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public List<ItemPedido> getItensPedido() {
		return this.itensPedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public BigDecimal getValorPedido() {
		return this.valorPedido;
	}
	
	public void calcularValorPedido() {
		this.valorPedido = new BigDecimal(0);

		List<ItemPedido> itens = this.getItensPedido();
		itens.forEach(item -> {
			this.valorPedido = this.valorPedido.add(item.getValorTotalItem());
		});
	}
	
}