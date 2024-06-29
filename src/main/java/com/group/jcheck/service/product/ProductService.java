package com.group.jcheck.service.product;

import com.group.jcheck.domain.product.Product;
import com.group.jcheck.dto.product.request.CreateProductRequest;
import com.group.jcheck.dto.product.request.UpdateProductRequest;
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
            throw new IllegalArgumentException("이미 해당 모델명으로 등록된 제품이 있습니다.");
        Product product = new Product(request);
        productRepository.save(product);
        return product.getProductModelName() + "제품이 정상적으로 등록되었습니다.";
    }

    @Transactional
    public List<ProductResponse> readProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public String updateProduct(UpdateProductRequest request) {
        Product product = productRepository.findByProductModelName(request.getProductModelName())
                .orElseThrow(IllegalArgumentException::new);
        if (productRepository.findByProductModelName(request.getNewProductModelName()).isPresent())
            throw new IllegalArgumentException("이미 해당 모델명으로 등록된 제품이 있습니다.");
        if (request.getNewProductModelName() != null)
            product.updateProductModelName(request.getNewProductModelName());
        if (request.getNewProductPetName() != null)
            product.updateProductPetName(request.getNewProductPetName());
        if (request.getNewProductMemory() != null)
            product.updateProductMemory(request.getNewProductMemory());
        if (request.getNewProductPrice() != null)
            product.updateProductPrice(request.getNewProductPrice());
        if (request.getNewProductManufacturer() != null)
            product.updateProductManufacturer(request.getNewProductManufacturer());
        if (request.getNewProductColors() != null)
            product.updateProductColors(request.getNewProductColors());
        return "제품 업데이트가 완료되었습니다.";
    }

    @Transactional
    public String deleteProduct(String productModelName) {
        Product product = productRepository.findByProductModelName(productModelName)
                .orElseThrow(IllegalArgumentException::new);
        String deleteProduct = product.getProductModelName();
        productRepository.delete(product);
        return deleteProduct + " 제품 삭제가 완료되었습니다.";
    }
}
