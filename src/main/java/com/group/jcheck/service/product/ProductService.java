package com.group.jcheck.service.product;

import com.group.jcheck.domain.product.Product;
import com.group.jcheck.dto.product.request.CreateProductRequest;
import com.group.jcheck.dto.product.response.ProductResponse;
import com.group.jcheck.repository.product.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public String createProduct(CreateProductRequest request) {
        if (productRepository.findByProductModelName(request.getProductModelName()).isPresent())
            throw new IllegalArgumentException("이미 해당 모델명으로 등록된 제품이 있습니다..");
        Product product = new Product(request);
        productRepository.save(product);
        return "제품이 정상적으로 등록되었습니다.";
    }

    @Transactional
    public List<ProductResponse> readProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }
}
