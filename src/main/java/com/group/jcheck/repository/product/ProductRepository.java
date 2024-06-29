package com.group.jcheck.repository.product;

import com.group.jcheck.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductPetNameContaining(String productPatName);
    Optional<Product> findByProductModelName(String productModelName);
}
