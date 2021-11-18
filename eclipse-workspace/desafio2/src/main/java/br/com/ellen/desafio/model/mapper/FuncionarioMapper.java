package br.com.ellen.desafio.model.mapper;

import br.com.ellen.desafio.model.Cargo;
import br.com.ellen.desafio.model.Empresa;
import br.com.ellen.desafio.model.Funcionario;
import br.com.ellen.desafio.model.dto.FuncionarioDto;

public class FuncionarioMapper {
	
	public static void merge(Funcionario result, FuncionarioDto from, Cargo cargo, Empresa empresa) {
        result.setName(from.getName());
        result.setCargo(cargo);
        result.setEmpresa(empresa);
        result.setSalario(from.getSalario());
    }

}
