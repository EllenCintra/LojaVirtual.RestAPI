package com.ellen.loja1.model.dto;

import java.math.BigDecimal;

import com.ellen.loja1.model.Item;

public class ItemDto {

	private long id;
	private ProductDto product;
	private int quantity;
	private BigDecimal value;
	
	public ItemDto() {
		
	}
	
	public ItemDto(Item itemPedido) {
		this.id = itemPedido.getId();
		this.product = itemPedido.getProduct().toDto();
		this.quantity = itemPedido.getQuantity();
		this.value = itemPedido.getValue();
	}
	
	public long getId() {
		return id;
	}

	public ProductDto getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	public BigDecimal getValue() {
		return value;
	}
	
}
