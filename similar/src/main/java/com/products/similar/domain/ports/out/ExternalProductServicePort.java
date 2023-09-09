package com.products.similar.domain.ports.out;

import com.products.similar.domain.models.Product;

import java.util.List;

public interface ExternalProductServicePort {
    Product getProductDetails(String id);
    List<String> getSimilarIds(String id);
}
