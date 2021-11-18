package br.com.ellen.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ellen.desafio.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
