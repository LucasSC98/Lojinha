package com.store.ljstore.repository;

import com.store.ljstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Integer> {
    List<Product> findAllByOrderByPrecoUnitarioAsc();
    List<Product> findAllByOrderByNomeAsc();
    List<Product> findAllByNomeContaining(String nome);
}
