package com.ellen.loja1.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull @NotEmpty
	private String name;
	@ManyToOne (cascade=CascadeType.ALL)
	@NotNull
	private Category category;
	private String details;
	@NotNull
	private BigDecimal price;

	public Product() {
	
	}
	
	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Category getCategoria() {
		return category;
	}
	
	public void setCategoria(Category category) {
		this.category = category;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String descricao) {
		this.details = descricao;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
