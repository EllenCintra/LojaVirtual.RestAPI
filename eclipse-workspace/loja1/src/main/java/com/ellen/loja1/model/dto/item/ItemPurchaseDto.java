package com.ellen.loja1.model.dto.item;

import java.math.BigDecimal;

import com.ellen.loja1.model.Item;
import com.ellen.loja1.model.dto.product.ProductPurchaseDto;

public class ItemPurchaseDto {
	
	private ProductPurchaseDto product;
	private int quantity;
	private BigDecimal value;
	
	public ItemPurchaseDto() {
		
	}
	
	public ItemPurchaseDto(Item item) {
		this.product = new ProductPurchaseDto(item.getProduct());
		this.quantity = item.getQuantity();
		this.value = item.getValue();
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
