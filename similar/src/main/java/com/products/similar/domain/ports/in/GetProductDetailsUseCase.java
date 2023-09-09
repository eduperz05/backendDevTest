package com.products.similar.domain.ports.in;

import com.products.similar.domain.models.Product;

public interface GetProductDetailsUseCase {
    Product getProductDetails(String id);
}
