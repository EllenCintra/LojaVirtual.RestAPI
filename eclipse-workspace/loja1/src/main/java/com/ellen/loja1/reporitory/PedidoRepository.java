package com.ellen.loja1.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ellen.loja1.modelo.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> getByCliente_Id(long id);

}
