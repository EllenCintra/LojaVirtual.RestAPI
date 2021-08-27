package com.ellen.loja1.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ellen.loja1.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
