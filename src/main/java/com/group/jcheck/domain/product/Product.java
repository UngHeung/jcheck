package com.group.jcheck.domain.product;

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

    public Product() {};

    public product() {

    }

    public void updateProductPrice(Integer newProductPrice) {
        this.productPrice = newProductPrice;
    }

    public void updateProductManufacturer(String newProductManufacturer) {
        this.productManufacturer = newProductManufacturer;
    }

    public void updateProductColor(String newProductColors) {
        this.productColors = newProductColors;
    }
}
