package com.ellen.loja1.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ellen.loja1.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

	List<Purchase> getByClient_Id(long id);
}
