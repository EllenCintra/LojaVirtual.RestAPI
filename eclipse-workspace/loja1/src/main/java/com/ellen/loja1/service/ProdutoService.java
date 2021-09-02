package com.ellen.loja1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ellen.loja1.controller.dto.ProdutoDto;
import com.ellen.loja1.modelo.Produto;
import com.ellen.loja1.reporitory.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDto> listarProdutos() {
		return produtoRepository.findAll()
				.stream()
				.map(ProdutoDto::new)
				.collect(Collectors.toList());
	}

	public ProdutoDto cadastrar (ProdutoDto produtoDto) {
		Produto produto = produtoDto.ofDto();
		produtoRepository.save(produto);
		return produto.toDto();
	}
}
