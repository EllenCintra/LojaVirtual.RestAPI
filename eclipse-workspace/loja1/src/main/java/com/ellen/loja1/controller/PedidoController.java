package com.ellen.loja1.controller;

import java.util.List;

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

import com.ellen.loja1.controller.dto.ClienteDto;
import com.ellen.loja1.controller.dto.PedidoDto;
import com.ellen.loja1.controller.dto.ProdutoDto;
import com.ellen.loja1.service.PedidoService;

@RestController
@RequestMapping("pedido")
public class PedidoController {
		
	@Autowired
	private PedidoService pedidoService; 

	@PostMapping
	@Transactional
	public ResponseEntity<PedidoDto> iniciarPedido (@RequestBody ClienteDto clienteDto) {
		return new ResponseEntity<>(pedidoService.novoPedido(clienteDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<PedidoDto> listarPedidos(){
		return pedidoService.listarPedidos();		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PedidoDto> adicionarItemAoPedido (@PathVariable Long id, @RequestBody ProdutoDto produtoDto) {
		return new ResponseEntity<>(pedidoService.adicionarItemAoPedido(id, produtoDto), HttpStatus.OK);
	}
	
	/*
	@GetMapping("/{pedidoId}")
	public List<ItemPedidoDto> listarItens(@PathVariable Long pedidoId){
		return pedidoService.listarItens(pedidoId);		
	}*/
	
	/*
	@PutMapping("/itemPedido/{id}")
	@Transactional
	public ResponseEntity<PedidoDto> alterarQtde (@PathVariable Long id, @RequestBody ItemPedidoDto itemDto) {
		return new ResponseEntity<>(pedidoService.alterarQtde(id, itemDto), HttpStatus.OK);
	}*/
	
	@DeleteMapping("{pedidoId}/{itemPedidoId}")
	@Transactional
	public ResponseEntity<PedidoDto> RemoverItem (@PathVariable Long pedidoId, Long itemPedidoId) {
		return new ResponseEntity<>(pedidoService.excluirItemDoCarrinho(pedidoId, itemPedidoId), HttpStatus.OK);
	}
	
}
