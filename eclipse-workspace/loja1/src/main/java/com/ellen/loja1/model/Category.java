package com.ellen.loja1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Category {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull @NotEmpty
	private String name;
	
	public Category() {
		
	}
	
	public Category(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
