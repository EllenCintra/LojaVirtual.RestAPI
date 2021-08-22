package com.ellen.loja1.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoDto {

	private long id;
	private ClienteDto cliente;
	private List<ItemPedidoDto> itensPedido = new ArrayList<>();
	private LocalDate dataPedido;
	private BigDecimal valorPedido;
	
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
		return valorPedido;
	}
	
	public long getId() {
		return id;
	}
}
