package br.com.ellen.desafio.model.dto;

import java.util.ArrayList;
import java.util.List;

public class EmpresaDto {
	
	private long id;
	private String name;
	private EnderecoDto endereco;
	private TelefoneDto teledone;
	private List<FuncionarioDto> funcionarios = new ArrayList<FuncionarioDto>();
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public EnderecoDto getEndereco() {
		return endereco;
	}
	public TelefoneDto getTeledone() {
		return teledone;
	}
	public List<FuncionarioDto> getFuncionarios() {
		return funcionarios;
	}


}
