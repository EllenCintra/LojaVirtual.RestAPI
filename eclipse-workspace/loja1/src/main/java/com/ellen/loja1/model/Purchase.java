package com.ellen.loja1.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.ellen.loja1.model.enums.PurchaseStatus;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade = CascadeType.ALL) @NotNull
	private Client client;


	@OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL) // mappedBy pq é um relacionamento bidirecional, ou seja,
																// tbm está definido na entidade Item. Se não
																// incluir o "mapped by) é criada uma outra tabela para
																// este relacionamento
	List<Item> items = new ArrayList<>();
	private LocalDate date = LocalDate.now();
	private BigDecimal value = BigDecimal.ZERO;
	@Enumerated(EnumType.STRING)
	private PurchaseStatus status = PurchaseStatus.EM_ABERTO;
	
	public Purchase() {
		
	}

	public Purchase(Client client) {
		this.client = client;
	}

	public long getId() {
		return id;
	}
	
	public Client getClient() {
		return client;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public LocalDate getDate() {
		return date;
	}

	public BigDecimal getValue() {
		return this.value;
	}
	
	public void calculatePurchaseValue() {
		this.value = new BigDecimal(0);

		List<Item> items = this.getItems();
		items.forEach(item -> {
			this.value = this.value.add(item.getValue());
		});
	}	
}