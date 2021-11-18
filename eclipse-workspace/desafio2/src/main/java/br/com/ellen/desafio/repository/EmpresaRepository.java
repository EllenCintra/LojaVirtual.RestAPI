package br.com.ellen.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ellen.desafio.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
