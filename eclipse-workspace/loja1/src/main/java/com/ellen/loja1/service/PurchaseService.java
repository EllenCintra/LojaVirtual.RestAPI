package com.ellen.loja1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ellen.loja1.model.Client;
import com.ellen.loja1.model.Item;
import com.ellen.loja1.model.Purchase;
import com.ellen.loja1.model.Product;
import com.ellen.loja1.model.dto.client.ClientDto;
import com.ellen.loja1.model.dto.item.ItemDto;
import com.ellen.loja1.model.dto.purchase.PurchaseCreateDto;
import com.ellen.loja1.model.dto.purchase.PurchaseDto;
import com.ellen.loja1.reporitory.ClientRepository;
import com.ellen.loja1.reporitory.ItemRepository;
import com.ellen.loja1.reporitory.PurchaseRepository;
import com.ellen.loja1.reporitory.ProductRepository;

@Service
public class PurchaseService {

	private PurchaseRepository purchaseRepository;
	private ItemRepository itemRepository;
	private ProductRepository productRepository;
	private ClientRepository clientRepository;
	
	public PurchaseService(PurchaseRepository purchaseRepository, ItemRepository itemRepository, ProductRepository productRepository, ClientRepository clientRepository) {
		this.purchaseRepository = purchaseRepository;
		this.itemRepository = itemRepository;
		this.productRepository = productRepository;
		this.clientRepository = clientRepository;
	}

	public PurchaseDto createPurchase(PurchaseCreateDto dto) {
		// Verificar se tem pedido em aberto para o cliente em questão. Se não tiver,
		// tem que criar um novo pedido.

		Client client = clientRepository.getById(dto.getClient().getId());
		Purchase purchase = new Purchase(client);

		return new PurchaseDto(purchaseRepository.save(purchase));
	}

	public PurchaseDto addItem(Long purchaseId, Long productId) {
		
		Purchase purchase = purchaseRepository.getById(purchaseId);
		Product product = productRepository.getById(productId);
			
			Item item = new Item(purchase, product);
			itemRepository.save(item);
			purchase.calculatePurchaseValue();

		return new PurchaseDto(purchaseRepository.save(purchase));
	}

	//Colocar no ClientService
	public List<PurchaseDto> listPurchase(ClientDto clientDto) {
		Client client = clientRepository.getById(clientDto.getId());
		List<Purchase> purchase = purchaseRepository.getByClient_Id(client.getId());

		return purchase.stream().map(PurchaseDto::new).collect(Collectors.toList());
	}

	public PurchaseDto getPurchase(Long purchaseId) {
		Purchase purchase = purchaseRepository.getById(purchaseId);
		return new PurchaseDto(purchase);
	}

	public PurchaseDto updateQuantity(Long purchaseId, ItemDto itemDto) {

		Item item = itemRepository.getById(itemDto.getId());
		
		if (itemDto.getQuantity() <= 0) {
			return deleteItem(purchaseId, item.getId());
		} else {
			item.setQuantity(itemDto.getQuantity());
			item.calculateItemValue();
			itemRepository.save(item);

			Purchase purchase = purchaseRepository.getById(purchaseId);
			purchase.calculatePurchaseValue();
			
			return new PurchaseDto(purchaseRepository.save(purchase));
		}
	}

	public PurchaseDto deleteItem(Long purchaseId, Long ItemId) {

		Item item = itemRepository.getById(ItemId);
		Purchase purchase = purchaseRepository.getById(purchaseId);

		purchase.getItems().remove(item);
		itemRepository.deleteById(ItemId);
		purchase.calculatePurchaseValue();
		
		return new PurchaseDto(purchaseRepository.save(purchase));
	}

}
