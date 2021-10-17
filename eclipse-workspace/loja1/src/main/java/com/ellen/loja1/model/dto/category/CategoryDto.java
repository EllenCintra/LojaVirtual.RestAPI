package com.ellen.loja1.model.dto.category;

import com.ellen.loja1.model.Category;

public class CategoryDto {
	
	private String name;
	
	public CategoryDto(Category category) {
		this.name = category.getName();
	}
	
	public String getName() {
		return name;
	}
}
