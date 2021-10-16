package com.ellen.loja1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ellen.loja1.model.Product;
import com.ellen.loja1.model.dto.ProductDto;
import com.ellen.loja1.reporitory.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;
	
	public ProductService (ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	

	public ProductDto insertProduct(ProductDto productDto) {
		Product product = productDto.ofDto(productDto);
		productRepository.save(product);
		return product.toDto();
	}
	
	public List<ProductDto> listProducts() {
		return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
	}

	public ProductDto getProduct(Long id) {
		return productRepository.getById(id).toDto();
	}
	
	public ProductDto updateProduct(Long id, ProductDto pDto) {
		Product p = productRepository.getById(id);
		p.setDescription(pDto.getDescription());
		p.setName(pDto.getName());
		p.setPrice(pDto.getPrice());
		
		return p.toDto();
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
