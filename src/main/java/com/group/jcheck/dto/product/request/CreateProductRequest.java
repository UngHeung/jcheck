package com.group.jcheck.dto.product.request;

import lombok.Getter;

@Getter
public class CreateProductRequest {
    private String productPetName;
    private String productModelName;
    private Integer productMemory;
    private Integer productPrice;
    private String productManufacturer;
    private String productColors;
}
