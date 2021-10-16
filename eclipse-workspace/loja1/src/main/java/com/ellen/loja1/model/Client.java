package com.ellen.loja1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ellen.loja1.model.dto.ClientDto;

@Entity
public class Client {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private String password;

	public Client () {
		
	}
	
	public Client (String nome, String email) {
		this.email = email;
		this.name = nome;
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public ClientDto toDto () {
		
		return new ClientDto(this);
	}
}
