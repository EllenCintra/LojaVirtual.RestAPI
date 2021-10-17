package com.ellen.loja1.model.dto.item;

import java.math.BigDecimal;

import com.ellen.loja1.model.Item;
import com.ellen.loja1.model.dto.product.ProductPurchaseDto;

public class ItemDto {

	private long id;
	private ProductPurchaseDto product;
	private int quantity;
	private BigDecimal value;
	
	public ItemDto() {
		
	}
	
	public ItemDto(Item item) {
		this.id = item.getId();
		this.product = new ProductPurchaseDto(item.getProduct());
		this.quantity = item.getQuantity();
		this.value = item.getValue();
	}
	
	public long getId() {
		return id;
	}

	public ProductPurchaseDto getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	public BigDecimal getValue() {
		return value;
	}
	
}
