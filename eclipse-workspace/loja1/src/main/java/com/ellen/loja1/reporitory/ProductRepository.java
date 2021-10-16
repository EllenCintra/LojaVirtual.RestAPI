package com.ellen.loja1.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ellen.loja1.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByCategory_Name(String name);
	List<Product> findByName(String name);
}
