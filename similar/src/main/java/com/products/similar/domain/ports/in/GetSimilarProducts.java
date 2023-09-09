package com.products.similar.domain.ports.in;

import com.products.similar.domain.models.Product;

import java.util.List;

public interface GetSimilarProducts {
    List<Product> getSimilarProducts(String id);
}
