package com.ellen.loja1.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ellen.loja1.modelo.Pedido;

public class PedidoDto {

	private long id;
	private ClienteDto cliente;
	private List<ItemPedidoDto> itensPedido = new ArrayList<>();
	private LocalDate dataPedido;
	private BigDecimal valorPedido;
	
	public PedidoDto() {
		
	}
	
	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.cliente = pedido.getCliente().toDto();
		this.itensPedido = pedido.getItensPedido().stream().map(ItemPedidoDto::new).collect(Collectors.toList());
		this.dataPedido = pedido.getDataPedido();
		this.valorPedido = pedido.getValorPedido();
	}
	
	public ClienteDto getCliente() {
		return cliente;
	}
	
	public List<ItemPedidoDto> getItensPedido() {
		return itensPedido;
	}
	
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	
	public BigDecimal getValorPedido() {
		return this.valorPedido;
	} 
	
	public long getId() {
		return id;
	}
}
