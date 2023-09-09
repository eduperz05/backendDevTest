package com.products.similar.domain.ports.in;

import com.products.similar.domain.models.Product;

import java.util.List;

public interface GetSimilarProductIdsUseCase {
    List<Product> getSimilarProductIds(String id);
}
