package com.ellen.loja1.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ellen.loja1.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

	List<Purchase> getByClient_Id(long id);
	
	@Query("SELECT p FROM Purchase p WHERE p.client.id = ?1")
	List<Purchase> selectPurchaseByClient(long id);
	
	@Query("SELECT p FROM Purchase p WHERE p.status='EM_ABERTO' AND p.client.id = ?1")
	Purchase selectOpenPurchaseByClient(long id);

}
