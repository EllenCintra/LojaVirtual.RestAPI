package com.ellen.loja1.model.dto;

import java.math.BigDecimal;

import com.ellen.loja1.model.Product;

public class ProductDto {

	private Long id; 
	private String name;
	private BigDecimal price;
	private String description;

	public ProductDto() {
		
	}
		
	public ProductDto(Product produto) {
		this.id = produto.getId();
		this.name = produto.getName();
		this.price = produto.getPrice();
		this.description = produto.getDescription();
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

	public String getDescription() {
		return description;
	}
	
	public Product ofDto(ProductDto dto) {
		  return new Product(dto.name, dto.price);
	}

}
