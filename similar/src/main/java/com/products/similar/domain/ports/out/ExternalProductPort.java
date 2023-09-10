package com.products.similar.domain.ports.out;

import com.products.similar.domain.models.Product;

import java.util.List;

public interface ExternalProductPort {
    Product getProductDetails(String id);
    List<String> getSimilarProductIds(String id);
}
