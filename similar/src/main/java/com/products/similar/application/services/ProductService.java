package com.products.similar.application.services;

import com.products.similar.application.dto.ProductDTO;
import com.products.similar.application.mapper.ProductMapper;
import com.products.similar.application.usecase.SimilarProductsUseCase;
import com.products.similar.domain.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final SimilarProductsUseCase similarProductsUseCase;

    public List<ProductDTO> getSimilarProducts(String productId) {
        List<Product> similarProducts = similarProductsUseCase.getSimilarProducts(productId);
        return similarProducts.stream()
                .map(ProductMapper::toProductDTO)
                .collect(Collectors.toList());
    }
}