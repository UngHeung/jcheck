package com.group.jcheck.repository.product;

import com.group.jcheck.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductPetNameContaining(String productPatName);
    List<Product> findByProductModelNameContaining(String productModelName);
}
