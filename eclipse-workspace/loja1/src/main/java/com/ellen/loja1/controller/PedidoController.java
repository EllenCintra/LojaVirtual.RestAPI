package com.ellen.loja1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ellen.loja1.modelo.Cliente;
import com.ellen.loja1.modelo.ItemPedido;
import com.ellen.loja1.modelo.Pedido;
import com.ellen.loja1.modelo.Produto;
import com.ellen.loja1.service.PedidoService;

@RestController
public class PedidoController {
		
	@Autowired
	private PedidoService pedidoService; 

	
	@RequestMapping ("/pedido")
	@PostMapping
	@Transactional
	public String iniciarPedido (@RequestBody Produto produto, Cliente cliente) {
		new Pedido(cliente);
		return "Vamos as compras!";
	}
	
	@RequestMapping ("/itempedido")
	@PostMapping
	@Transactional
	public String adicionarItemAoPedido (@RequestBody Pedido pedido, Produto produto) {
		this.pedidoService.adicionarAoCarrinho(pedido, produto);
		return produto.getNome().concat(" adicionado ao carrinho!");
	}
	
	@RequestMapping ("/meupedido")
	@GetMapping
	public List<ItemPedido> meuCarrinho(@RequestBody Pedido pedido){
		return pedido.getItensPedido();		
	}
	
	@RequestMapping ("/itempedido/addUnidade")
	@PutMapping
	@Transactional
	public void adicionarUnidade (@RequestBody ItemPedido itemPedido) {
		this.pedidoService.adicionarUnidade(itemPedido);
	}
	
	@RequestMapping ("/itempedido/removerUnidade")
	@PutMapping
	@Transactional
	public void removerUnidade (@RequestBody Pedido pedido, ItemPedido itemPedido) {
		this.pedidoService.removerUnidade(pedido, itemPedido);
	}
	
	@RequestMapping ("/itempedido/removerItem")
	@DeleteMapping
	@Transactional
	public void RemoverItem (@RequestBody Pedido pedido, ItemPedido itemPedido) {
		this.pedidoService.excluirItemDoCarrinho(pedido, itemPedido);
	}
	
}
