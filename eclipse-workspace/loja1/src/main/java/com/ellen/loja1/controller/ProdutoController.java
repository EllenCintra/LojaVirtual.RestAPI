package com.ellen.loja1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ellen.loja1.controller.dto.ProdutoDto;
import com.ellen.loja1.service.ProdutoService;

@RestController
@RequestMapping ("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<ProdutoDto> produtos() {
		return produtoService.listarProdutos();			
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoDto produtoDto) {
        return new ResponseEntity<>(produtoService.cadastrar(produtoDto), HttpStatus.CREATED);
	}

}
