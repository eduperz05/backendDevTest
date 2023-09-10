package com.products.similar.infrastructure.repository;

import com.products.similar.application.mapper.ProductMapper;
import com.products.similar.domain.models.Product;
import com.products.similar.domain.ports.out.ExternalProductPort;
import com.products.similar.infrastructure.adapters.client.ProductFeignClientAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductRepository implements ExternalProductPort {

    private final ProductFeignClientAdapter productFeignClientAdapter;

    public Product getProductDetails(String productId) {
        return ProductMapper.toProduct(productFeignClientAdapter.getProductDetails(productId));
    }

    public List<String> getSimilarProductIds(String productId) {
        return productFeignClientAdapter.getSimilarProductIds(productId);
    }
}
