package com.ellen.loja1.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ellen.loja1.modelo.ItemPedido;
import com.ellen.loja1.modelo.Pedido;
import com.ellen.loja1.modelo.Produto;
import com.ellen.loja1.reporitory.ItemPedidoRepository;
import com.ellen.loja1.reporitory.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void adicionarAoCarrinho(Pedido pedido, Produto produto) {
		ItemPedido itemPedido = new ItemPedido(pedido, produto);
	}
	
	public void adicionarUnidade(ItemPedido itemPedido) {
		itemPedido.quantidade =+ 1;
		calcularValorItem(itemPedido);
	}
	
	public void removerUnidade(Pedido pedido, ItemPedido itemPedido) {
		itemPedido.quantidade =- 1;
		if (itemPedido.quantidade == 0) {
			excluirItemDoCarrinho(pedido, itemPedido);
		}
		calcularValorItem(itemPedido);
	}

	private void calcularValorItem(ItemPedido itemPedido) {
		itemPedido.valorTotalItem = itemPedido.getProduto().getPreco().multiply(new BigDecimal(itemPedido.getQuantidade()));
	}
	
	public void excluirItemDoCarrinho(Pedido pedido, ItemPedido itemPedido) {
		pedido.valorPedido.subtract(itemPedido.valorTotalItem);
		pedido.getItensPedido().remove(itemPedido);
	}
}
