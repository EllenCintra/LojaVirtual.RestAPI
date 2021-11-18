package br.com.ellen.desafio.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.ellen.desafio.model.dto.FuncionarioDto;
import br.com.ellen.desafio.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	private FuncionarioService funcionarioService;
	
	public FuncionarioController(FuncionarioService service) {
		this.funcionarioService = service;
	}

	@PostMapping
	public ResponseEntity<FuncionarioDto> insertFuncionario (@RequestBody @Valid FuncionarioDto funcionarioDto) {
		return new ResponseEntity<FuncionarioDto>(funcionarioService.insertFuncionario(funcionarioDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/todosfuncionarios")
	public List<FuncionarioDto> funcionarios() {
		return funcionarioService.listFuncionarios();		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FuncionarioDto> updateFuncionario(@PathVariable Long id, @RequestBody @Valid FuncionarioDto funcionarioDto) {
		return new ResponseEntity<FuncionarioDto>(funcionarioService.updateFuncionario(id, funcionarioDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFuncionario(@PathVariable Long id) {
		funcionarioService.deleteFuncionario(id);
		return ResponseEntity.ok().build();
	}
}
