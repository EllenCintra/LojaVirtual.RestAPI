package com.ellen.loja1.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ellen.loja1.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	Category findByName(String name);
}
