package com.ellen.loja1.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ellen.loja1.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
