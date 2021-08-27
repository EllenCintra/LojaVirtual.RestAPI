package com.ellen.loja1.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.ellen.loja1.modelo.Cliente;
import com.ellen.loja1.modelo.ItemPedido;
import com.ellen.loja1.modelo.Pedido;

public class PedidoDto {

	private long id;
	private Cliente cliente;
	private List<ItemPedido> itensPedido = new ArrayList<>();
	private LocalDate dataPedido;
	private BigDecimal valorPedido;
	
	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.cliente = pedido.getCliente();
		this.itensPedido = pedido.getItensPedido();
		this.dataPedido = pedido.getDataPedido();
		this.valorPedido = pedido.getValorPedido();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}
	
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	
	public BigDecimal getValorPedido() {
		return valorPedido;
	} 
	
	public long getId() {
		return id;
	}
	
	public static Page<PedidoDto> converter(Page<Pedido> pedido){
		return pedido.map(PedidoDto::new);
	}
}
