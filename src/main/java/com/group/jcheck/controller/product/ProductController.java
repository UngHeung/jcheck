package com.group.jcheck.controller.product;

import com.group.jcheck.dto.product.request.CreateProductRequest;
import com.group.jcheck.dto.product.request.UpdateProductRequest;
import com.group.jcheck.dto.product.response.ProductResponse;
import com.group.jcheck.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(@RequestBody ProductService productService) {
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

    @PutMapping("/product")
    public String updateProduct(@RequestBody UpdateProductRequest request) {
        return productService.updateProduct(request);
    }

    @DeleteMapping("/product")
    public String deleteProduct(@RequestBody Map<String, String> request) {
        return productService.deleteProduct(request.get("productModelName"));
    }
}
