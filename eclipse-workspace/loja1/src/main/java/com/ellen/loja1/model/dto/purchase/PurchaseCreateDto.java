package com.ellen.loja1.model.dto.purchase;

import com.ellen.loja1.model.dto.client.ClientCreatePurchaseDto;

public class PurchaseCreateDto {
	
	private ClientCreatePurchaseDto client;
	
	public PurchaseCreateDto() {
		
	}
	
	public PurchaseCreateDto(ClientCreatePurchaseDto client) {
		this.client = client;
	}

	public ClientCreatePurchaseDto getClient() {
		return client;
	}
}
