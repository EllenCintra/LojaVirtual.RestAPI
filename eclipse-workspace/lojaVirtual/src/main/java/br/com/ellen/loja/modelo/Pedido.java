package br.com.ellen.loja.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Cliente cliente;
	
	private List<ItemPedido> itensPedido;
	private BigDecimal valorPedido;
	
	public Pedido (Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addItem (ItemPedido ip) {
		this.itensPedido.add(ip);
		this.valorPedido.add(ip.getValorPorItem());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}
	
	
	
}
