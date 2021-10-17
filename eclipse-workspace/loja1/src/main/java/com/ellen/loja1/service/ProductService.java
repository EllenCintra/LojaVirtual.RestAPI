package com.ellen.loja1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ellen.loja1.model.Category;
import com.ellen.loja1.model.Product;
import com.ellen.loja1.model.dto.product.ProductCreateUpdateDto;
import com.ellen.loja1.model.dto.product.ProductDto;
import com.ellen.loja1.model.mapper.ProductMapper;
import com.ellen.loja1.reporitory.CategoryRepository;
import com.ellen.loja1.reporitory.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	

	/*
	 * No cadastro de Produto a categoria deveria ser selecionada dentre as já existentes, 
	 * utilizando uma Select Box que busca as categorias direto no DB
	 * Próxima a essa Select Box, haveria um botão "Criar nova Categoria" que redicionaria para a página que cria novas categorias
	 */
	public ProductDto insertProduct(ProductCreateUpdateDto productDto) {
		Category category = categoryRepository.findByName(productDto.getCategory());
		Product product = new Product();
		ProductMapper.merge(product, productDto, category);
		return new ProductDto(productRepository.save(product));
	}

	public List<ProductDto> listProducts() {
		return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
	}

	public ProductDto getProduct(Long id) {
		return new ProductDto(productRepository.getById(id));
	}

	public ProductDto updateProduct(Long id, ProductCreateUpdateDto pDto) {
		Product product = productRepository.getById(id);
		Category category = categoryRepository.findByName(pDto.getCategory());
		ProductMapper.merge(product, pDto, category);

		return new ProductDto(product);
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
