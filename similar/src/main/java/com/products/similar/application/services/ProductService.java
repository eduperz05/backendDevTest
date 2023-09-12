package com.products.similar.application.services;

import com.products.similar.application.dto.ProductDTO;
import com.products.similar.application.mapper.ProductMapper;
import com.products.similar.application.usecase.SimilarProductsUseCase;
import com.products.similar.domain.models.Product;
import com.products.similar.infrastructure.exceptions.ProductNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final SimilarProductsUseCase similarProductsUseCase;

    public List<ProductDTO> getSimilarProducts(String productId) {
        log.info("Fetching similar products for product ID: {}", productId);
        List<Product> similarProducts = similarProductsUseCase.getSimilarProducts(productId);

        if (similarProducts == null || similarProducts.isEmpty()) {
            log.warn("No similar products found for product ID: {}", productId);
            throw new ProductNotFoundException("Product Not found.");
        }

        log.info("Found {} similar products for product ID: {}", similarProducts.size(), productId);
        return similarProducts.stream()
                .map(ProductMapper::toProductDTO)
                .collect(Collectors.toList());
    }
}