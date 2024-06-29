package com.group.jcheck.domain.product;

import com.group.jcheck.dto.product.request.CreateProductRequest;
import com.group.jcheck.dto.product.request.UpdateProductRequest;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 40)
    private String productPetName;
    @Column(nullable = false, length = 20)
    private String productModelName;
    @Column(nullable = false)
    private Integer productMemory;
    @Column(nullable = false)
    private Integer productPrice;
    @Column(length = 10)
    private String productManufacturer;
    @Column(length = 100)
    private String productColors;

    public Product() {}

    public Product(CreateProductRequest request) {
        this.productPetName = request.getProductPetName();
        this.productModelName = request.getProductModelName();
        this.productMemory = request.getProductMemory();
        this.productPrice = request.getProductPrice();
        this.productManufacturer = request.getProductManufacturer();
        this.productColors = request.getProductColors();
    }

    public void updateProductPetName(String newProductPetName) {
        this.productPetName = newProductPetName;
    }
    public void updateProductModelName(String newProductModelName) {
        this.productModelName = newProductModelName;
    }
    public void updateProductMemory(Integer newProductMemory) {
        this.productMemory = newProductMemory;
    }
    public void updateProductPrice(Integer newProductPrice) {
        this.productPrice = newProductPrice;
    }
    public void updateProductManufacturer(String newProductManufacturer) {
        this.productManufacturer = newProductManufacturer;
    }
    public void updateProductColors(String newProductColors) {
        this.productColors = newProductColors;
    }
}
