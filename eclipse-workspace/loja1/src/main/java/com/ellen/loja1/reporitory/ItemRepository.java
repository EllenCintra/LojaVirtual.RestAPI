package com.ellen.loja1.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ellen.loja1.model.Item;
import com.ellen.loja1.model.Product;

public interface ItemRepository extends JpaRepository<Item, Long> {

	Product getByProduct_Id(long id);
	
	@Query("SELECT i FROM Item i WHERE purchase.id = ?1 AND i.product.id = ?2")
	Item selectProductByPurchase(long idPurchase, long idProduct);
}
