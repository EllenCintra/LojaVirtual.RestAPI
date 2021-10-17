package com.ellen.loja1.controller;

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

import com.ellen.loja1.model.dto.item.ItemDto;
import com.ellen.loja1.model.dto.purchase.PurchaseCreateDto;
import com.ellen.loja1.model.dto.purchase.PurchaseDto;
import com.ellen.loja1.service.PurchaseService;

@RestController
@RequestMapping("pedido")
public class PurchaseController {
		
	private PurchaseService purchaseService; 
	
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PurchaseDto> createPurchase (@RequestBody PurchaseCreateDto dto) {
		return new ResponseEntity<>(purchaseService.createPurchase(dto), HttpStatus.CREATED);
	}
	
	@PostMapping("/{purchaseId}/produto/{productId}")
	@Transactional
	public ResponseEntity<PurchaseDto> addItem (@PathVariable Long purchaseId, @PathVariable Long productId) {
		return new ResponseEntity<>(purchaseService.addItem(purchaseId, productId), HttpStatus.CREATED);
	}
	
	@GetMapping("/{purchaseId}")
	public ResponseEntity<PurchaseDto> getPurchase(@PathVariable Long purchaseId){
		return new ResponseEntity<>(purchaseService.getPurchase(purchaseId), HttpStatus.OK);	
	}
	
	@PutMapping("/{purchaseId}")
	@Transactional
	public ResponseEntity<PurchaseDto> updateQuantity (@PathVariable Long purchaseId, @RequestBody ItemDto itemDto) {
		return new ResponseEntity<>(purchaseService.updateQuantity(purchaseId, itemDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{purchaseId}/produto/{itemId}")
	@Transactional
	public ResponseEntity<PurchaseDto> deleteItem (@PathVariable Long purchaseId, @PathVariable Long itemId) {
		return new ResponseEntity<>(purchaseService.deleteItem(purchaseId, itemId), HttpStatus.OK);
	}
	
}
