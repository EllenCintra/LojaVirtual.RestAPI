package com.ellen.loja1.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Purchase purchase;
	@ManyToOne
	private Product product;
	private int quantity = 1;
	private BigDecimal valor;
	
	public Item() {
		
	}
	
	public Item (Purchase pur, Product prod) {
		this.purchase = pur;
		this.product = prod;
		this.valor = prod.getPrice();
	}

	public long getId() {
		return id;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public int setQuantity(int qtde) {
		return this.quantity = qtde;
	}

	public BigDecimal getValue() {
		return valor;
	}	
	
	public void calculateItemValue() {
		this.valor = this.getProduct().getPrice()
				.multiply(new BigDecimal(this.quantity));
	}
}
