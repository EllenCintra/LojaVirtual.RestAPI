package com.ellen.loja1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {
	
	
	@RequestMapping ("/meuspedidos")
	public String hello() {
		return "Welcome to Palikir!";
	}
}
