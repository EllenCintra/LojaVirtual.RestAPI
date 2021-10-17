package com.ellen.loja1.model.dto.client;

import com.ellen.loja1.model.Client;

public class ClientDto {
	
	private long id;
	private String name;
	
	public ClientDto() {
		
	}
	
	public ClientDto(Client cliente) {
		this.id = cliente.getId();
		this.name = cliente.getName();
	}
	
	public long getId() {
		return id;
	}
	public String getNome() {
		return name;
	}
}
