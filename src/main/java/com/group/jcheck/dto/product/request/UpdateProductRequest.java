package com.group.jcheck.dto.product.request;

import lombok.Getter;

@Getter
public class UpdateProductRequest {
    private String productModelName;
    private String newProductPetName;
    private String newProductModelName;
    private Integer newProductMemory;
    private Integer newProductPrice;
    private String newProductManufacturer;
    private String newProductColors;
}
