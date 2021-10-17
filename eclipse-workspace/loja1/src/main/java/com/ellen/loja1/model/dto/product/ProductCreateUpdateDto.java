package com.ellen.loja1.model.dto.product;

import java.math.BigDecimal;


public class ProductCreateUpdateDto {

	private String category;
	private String name;
	private BigDecimal price;
	private String details;
	
	public ProductCreateUpdateDto(){
		
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public String getDetails() {
		return details;
	}
	
}
