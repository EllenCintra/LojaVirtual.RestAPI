package com.ellen.loja1.controller.dto;

import com.ellen.loja1.modelo.Cliente;

public class ClienteDto {
	
	private long id;
	private String nome;
	
	public ClienteDto() {
		
	}
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
	}
	
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
}
