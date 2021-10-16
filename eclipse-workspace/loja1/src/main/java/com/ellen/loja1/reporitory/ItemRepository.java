package com.ellen.loja1.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ellen.loja1.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
