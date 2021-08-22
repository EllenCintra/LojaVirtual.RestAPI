package com.ellen.loja1.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ellen.loja1.modelo.Cliente;
import com.ellen.loja1.modelo.ItemPedido;
import com.ellen.loja1.modelo.Pedido;
import com.ellen.loja1.modelo.Produto;

@RestController
public class PedidoController {
	
	
	@RequestMapping ("/")
	public String hello() {
		return "Welcome to Palikir!";
	}
	
	@RequestMapping ("/adicionarItemAoCarrinho")
	@PostMapping
	@Transactional
	public String adicionarItemAoPedido (@RequestBody Produto produto, Cliente cliente) {
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItemAoPedido(produto);
		return produto.getNome().concat(" adicionado ao carrinho!");
	}
	
	@RequestMapping ("/meuCarrinho")
	@GetMapping
	public List<ItemPedido> meuCarrinho(@RequestBody Pedido pedido){
		return pedido.getItensPedido();		
	}
	
}
