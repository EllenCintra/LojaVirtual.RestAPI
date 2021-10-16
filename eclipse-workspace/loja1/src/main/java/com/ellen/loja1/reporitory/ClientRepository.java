package com.ellen.loja1.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ellen.loja1.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
