package com.ellen.loja1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Cliente cliente;
	@OneToMany (mappedBy = "pedido", cascade = CascadeType.ALL)//mappedBy pq é um relacionamento bidirecional, ou seja, tbm está definifo na entidade ItemPedido. Se não avisar é criada uma outra tabela para este relacionamento
	private List<ItemPedido> itemPedido = new ArrayList<>();
}
