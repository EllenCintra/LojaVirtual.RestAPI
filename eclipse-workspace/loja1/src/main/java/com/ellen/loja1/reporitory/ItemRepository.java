package com.ellen.loja1.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ellen.loja1.model.Item;
import com.ellen.loja1.model.Product;

public interface ItemRepository extends JpaRepository<Item, Long> {

	Product getByProduct_Id(long id);
}
