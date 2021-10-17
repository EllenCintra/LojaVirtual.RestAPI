package com.ellen.loja1.model.dto.product;

import java.math.BigDecimal;

import com.ellen.loja1.model.Product;

public class ProductDto {

	private Long id; 
	private String category;
	private String name;
	private BigDecimal price;
	private String details;


	public ProductDto() {
		
	}
		
	public ProductDto(Product product) {
		this.id = product.getId();
		this.category = product.getCategoria().getName();
		this.name = product.getName();
		this.price = product.getPrice();
		this.details = product.getDetails();
	}

	public Long getId() {
		return id;
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

	public String getCategory() {
		return category;
	}

}
