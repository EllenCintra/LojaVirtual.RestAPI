package com.ellen.loja1.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ellen.loja1.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findByCategoria_Nome(String nome);
	List<Produto> findByNome(String nome);
}
