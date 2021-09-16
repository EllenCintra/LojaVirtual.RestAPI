package com.ellen.loja1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ellen.loja1.controller.dto.ProdutoDto;
import com.ellen.loja1.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<ProdutoDto> produtos() {
		return produtoService.listarProdutos();
	}

	@GetMapping("/{id}")
	public ProdutoDto buscarProduto(@PathVariable Long id) {
		return produtoService.buscarId(id);
	}

	@PostMapping
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody/*@Valid/*Bean validation*/ ProdutoDto produtoDto) {
        return new ResponseEntity<>(produtoService.cadastrar(produtoDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoDto produtoDto) {
        return new ResponseEntity<>(produtoService.atualizar(id, produtoDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar (@PathVariable Long id) {
		produtoService.deletar(id);
		return ResponseEntity.ok().build();
	}	

}
