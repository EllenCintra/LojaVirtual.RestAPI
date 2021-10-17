package com.ellen.loja1.model.dto.purchase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ellen.loja1.model.Purchase;
import com.ellen.loja1.model.dto.client.ClientDto;
import com.ellen.loja1.model.dto.item.ItemPurchaseDto;

public class PurchaseDto {

	private long id;
	private ClientDto client;
	private LocalDate date;
	private List<ItemPurchaseDto> items = new ArrayList<>();
	private BigDecimal value;
	
	public PurchaseDto() {
		
	}
	
	public PurchaseDto(Purchase purchase) {
		this.id = purchase.getId();
		this.client = new ClientDto(purchase.getClient());
		this.items = purchase.getItems().stream().map(ItemPurchaseDto::new).collect(Collectors.toList());
		this.date = purchase.getDate();
		this.value = purchase.getValue();
	}
	
	public ClientDto getClient() {
		return client;
	}
	
	public List<ItemPurchaseDto> getItems() {
		return items;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public BigDecimal getValue() {
		return this.value;
	} 
	
	public long getId() {
		return id;
	}
}
