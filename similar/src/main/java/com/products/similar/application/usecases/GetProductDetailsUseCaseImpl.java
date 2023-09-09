package com.products.similar.application.usecases;

import com.products.similar.domain.models.Product;
import com.products.similar.domain.ports.in.GetProductDetailsUseCase;
import com.products.similar.domain.ports.in.GetSimilarProductIdsUseCase;
import com.products.similar.domain.ports.out.ExternalProductServicePort;

import java.util.List;

public class GetProductDetailsUseCaseImpl implements GetProductDetailsUseCase {

    private final ExternalProductServicePort externalProductServicePort;

    public GetProductDetailsUseCaseImpl(ExternalProductServicePort externalProductServicePort) {
        this.externalProductServicePort = externalProductServicePort;
    }

    @Override
    public Product getProductDetails(String id) {
        return externalProductServicePort.getProductDetails(id);
    }
}
