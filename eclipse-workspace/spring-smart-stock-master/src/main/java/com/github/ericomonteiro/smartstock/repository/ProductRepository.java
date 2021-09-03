package com.github.ericomonteiro.smartstock.repository;

import com.github.ericomonteiro.smartstock.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNameIgnoreCase (String name);
    Optional<Product> findByNameIgnoreCaseAndIdIsNot(String name, Long id);
}
