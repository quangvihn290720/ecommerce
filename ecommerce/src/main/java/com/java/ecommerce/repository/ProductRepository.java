package com.java.ecommerce.repository;

import com.java.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    boolean existsByCode(String code);
    Optional<Product> findProductByCode(String code);
    void deleteProductByCode(String code);
}
