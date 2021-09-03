package com.github.ericomonteiro.smartstock.integration.viavep.dto;

import lombok.Data;

@Data
public class ViaCepAddressDto {
	private String uf;
	private String complemento;
	private String ddd;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String ibge;
	private String siafi;
	private String gia;
	private String cep;
}
