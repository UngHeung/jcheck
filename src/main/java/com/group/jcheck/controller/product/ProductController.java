package com.group.jcheck.controller.product;

import com.group.jcheck.dto.product.request.CreateProductRequest;
import com.group.jcheck.dto.product.response.ProductResponse;
import com.group.jcheck.service.product.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public String createProduct(@RequestBody CreateProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping("/product")
    public List<ProductResponse> readProduct() {
        return productService.readProducts();
    }
}
