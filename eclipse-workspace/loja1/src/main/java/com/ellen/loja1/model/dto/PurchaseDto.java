package com.ellen.loja1.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ellen.loja1.model.Purchase;

public class PurchaseDto {

	private long id;
	private ClientDto client;
	private List<ItemDto> items = new ArrayList<>();
	private LocalDate date;
	private BigDecimal value;
	
	public PurchaseDto() {
		
	}
	
	public PurchaseDto(Purchase purchase) {
		this.id = purchase.getId();
		this.client = purchase.getClient().toDto();
		this.items = purchase.getItems().stream().map(ItemDto::new).collect(Collectors.toList());
		this.date = purchase.getDate();
		this.value = purchase.getValue();
	}
	
	public ClientDto getClient() {
		return client;
	}
	
	public List<ItemDto> getItems() {
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
