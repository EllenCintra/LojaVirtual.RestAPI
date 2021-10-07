package com.ellen.loja1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ellen.loja1.controller.dto.ClienteDto;
import com.ellen.loja1.controller.dto.ItemPedidoDto;
import com.ellen.loja1.controller.dto.PedidoDto;
import com.ellen.loja1.modelo.Cliente;
import com.ellen.loja1.modelo.ItemPedido;
import com.ellen.loja1.modelo.Pedido;
import com.ellen.loja1.modelo.Produto;
import com.ellen.loja1.reporitory.ClienteRepository;
import com.ellen.loja1.reporitory.ItemPedidoRepository;
import com.ellen.loja1.reporitory.PedidoRepository;
import com.ellen.loja1.reporitory.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public PedidoDto novoPedido(ClienteDto clienteDto) {
		// Verificar se tem pedido em aberto para o cliente em questão. Se não tiver,
		// tem que criar um novo pedido.

		Cliente cliente = clienteRepository.getById(clienteDto.getId());
		Pedido pedido = new Pedido(cliente);
		Pedido pedidoSalvo = pedidoRepository.save(pedido);

		cliente.getPedidos().add(pedidoSalvo);
		clienteRepository.save(cliente);

		return new PedidoDto(pedidoSalvo);
	}

	public PedidoDto adicionarItemAoPedido(Long idPed, Long idProd) {
		
		Pedido pedido = pedidoRepository.getById(idPed);
		Produto produto = produtoRepository.getById(idProd);

		ItemPedido itemPedido = new ItemPedido(pedido, produto);
		itemPedidoRepository.save(itemPedido);
		pedido.calcularValorPedido();
		
		return new PedidoDto(pedidoRepository.save(pedido));
	}

	public List<PedidoDto> listarPedidos(ClienteDto clienteDto) {
		Cliente cliente = clienteRepository.getById(clienteDto.getId());
		List<Pedido> pedidos = pedidoRepository.getByCliente_Id(cliente.getId());

		return pedidos.stream().map(PedidoDto::new).collect(Collectors.toList());
	}

	public List<ItemPedidoDto> listarItens(Long pedidoId) {
		Pedido pedido = pedidoRepository.getById(pedidoId);
		List<ItemPedido> itens = pedido.getItensPedido();
		return itens.stream().map(ItemPedidoDto::new).collect(Collectors.toList());
	}

	public PedidoDto alterarQtde(Long pedidoId, ItemPedidoDto itemDto) {

		ItemPedido itemPedido = itemPedidoRepository.getById(itemDto.getId());
		
		if (itemDto.getQuantidade() <= 0) {
			return excluirItemDoCarrinho(pedidoId, itemPedido.getId());
		} else {
			itemPedido.setQuantidade(itemDto.getQuantidade());
			itemPedido.calcularValorItem();
			itemPedidoRepository.save(itemPedido);

			Pedido pedido = pedidoRepository.getById(pedidoId);
			pedido.calcularValorPedido();
			
			return new PedidoDto(pedidoRepository.save(pedido));
		}
	}

	public PedidoDto excluirItemDoCarrinho(Long pedidoId, Long itemPedidoId) {

		ItemPedido itemPedido = itemPedidoRepository.getById(itemPedidoId);
		Pedido pedido = pedidoRepository.getById(pedidoId);

		pedido.getItensPedido().remove(itemPedido);
		itemPedidoRepository.deleteById(itemPedidoId);
		pedido.calcularValorPedido();
		
		return new PedidoDto(pedidoRepository.save(pedido));
	}

}
