package com.group.jcheck.dto.product.response;

import com.group.jcheck.domain.product.Product;
import lombok.Data;

@Data
public class ProductResponse {
    private final Long id;
    private final String productPetName;
    private final String productModelName;
    private final Integer productMemory;
    private final Integer productPrice;
    private final String productManufacturer;
    private final String productColors;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.productPetName = product.getProductPetName();
        this.productModelName = product.getProductModelName();
        this.productMemory = product.getProductMemory();
        this.productPrice = product.getProductPrice();
        this.productManufacturer = product.getProductManufacturer();
        this.productColors = product.getProductColors();
    }
}
