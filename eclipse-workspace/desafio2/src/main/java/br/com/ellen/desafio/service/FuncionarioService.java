package br.com.ellen.desafio.service;

import java.util.List;

import javax.validation.Valid;

import br.com.ellen.desafio.model.Cargo;
import br.com.ellen.desafio.model.Empresa;
import br.com.ellen.desafio.model.Funcionario;
import br.com.ellen.desafio.model.dto.FuncionarioDto;
import br.com.ellen.desafio.model.mapper.FuncionarioMapper;
import br.com.ellen.desafio.repository.CargoRepository;
import br.com.ellen.desafio.repository.EmpresaRepository;
import br.com.ellen.desafio.repository.FuncionarioRepository;

public class FuncionarioService {
	
	private FuncionarioRepository funcionarioRepository;
	private CargoRepository cargoRepository;
	private EmpresaRepository empresaRepository;
	

	public FuncionarioDto insertFuncionario(@Valid FuncionarioDto funcionarioDto) {
		Cargo cargo = cargoRepository.getById(funcionarioDto.getCargo().getId());
		Empresa empresa = empresaRepository.getById(funcionarioDto.getEmpresa().getId());
		Funcionario funcionario = new Funcionario();
		FuncionarioMapper.merge(funcionario, funcionarioDto, cargo, empresa);
		return new FuncionarioDto(funcionarioRepository.save(funcionario));
	}

	public List<FuncionarioDto> listFuncionarios() {
		// TODO Auto-generated method stub
		return null;
	}

	public FuncionarioDto updateFuncionario(Long id, @Valid FuncionarioDto funcionarioDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteFuncionario(Long id) {
		// TODO Auto-generated method stub
		
	}

}
