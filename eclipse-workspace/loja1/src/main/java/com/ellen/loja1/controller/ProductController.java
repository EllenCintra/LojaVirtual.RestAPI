package com.ellen.loja1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ellen.loja1.model.dto.product.ProductCreateUpdateDto;
import com.ellen.loja1.model.dto.product.ProductDto;
import com.ellen.loja1.service.ProductService;

@RestController
@RequestMapping("/produto")
public class ProductController {

	private ProductService productService;

	public ProductController (ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/todosprodutos")
	public List<ProductDto> products() {
		return productService.listProducts();
	}

	@GetMapping("/{id}")
	public ProductDto getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}

	@PostMapping
	public ResponseEntity<ProductDto> insertProduct(@RequestBody @Valid/*Bean validation */ ProductCreateUpdateDto productDto) {
		return new ResponseEntity<>(productService.insertProduct(productDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductCreateUpdateDto productDto) {
		return new ResponseEntity<>(productService.updateProduct(id, productDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok().build();
	}

}
