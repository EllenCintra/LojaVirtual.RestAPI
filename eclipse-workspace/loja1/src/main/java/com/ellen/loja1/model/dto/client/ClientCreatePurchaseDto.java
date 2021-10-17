package com.ellen.loja1.model.dto.client;

import com.ellen.loja1.model.Client;

public class ClientCreatePurchaseDto {
	
	private long id;
	
	public ClientCreatePurchaseDto() {
		
	}
	
	public ClientCreatePurchaseDto(Client cliente) {
		this.id = cliente.getId();
	}
	
	public long getId() {
		return id;
	}

}
