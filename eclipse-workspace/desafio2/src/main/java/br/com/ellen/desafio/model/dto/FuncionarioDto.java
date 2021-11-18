package br.com.ellen.desafio.model.dto;

import java.math.BigDecimal;

import br.com.ellen.desafio.model.Funcionario;

public class FuncionarioDto {
	
	private long id;
	private String name;
	private EmpresaDto empresa;
	private CargoDto cargo;
	private BigDecimal salario;
	
	public FuncionarioDto(Funcionario save) {
		this.id = save.getId();
		this.name = save.getName();
		
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public EmpresaDto getEmpresa() {
		return empresa;
	}
	public CargoDto getCargo() {
		return cargo;
	}
	public BigDecimal getSalario() {
		return salario;
	}

}
