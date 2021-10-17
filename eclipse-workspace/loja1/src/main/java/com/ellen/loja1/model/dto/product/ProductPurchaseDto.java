package com.ellen.loja1.model.dto.product;

import java.math.BigDecimal;

import com.ellen.loja1.model.Product;

public class ProductPurchaseDto {
	
	private String name;
	private BigDecimal price;
	
	public ProductPurchaseDto() {
		
	}
		
	public ProductPurchaseDto(Product product) {
		this.name = product.getName();
		this.price = product.getPrice();
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

}
