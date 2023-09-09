package com.products.similar.application.usecases;

import com.products.similar.domain.ports.in.GetSimilarProductIdsUseCase;
import com.products.similar.domain.ports.out.ExternalProductServicePort;

public class GetSimilarProductsUseCaseImplUseCase implements GetSimilarProductIdsUseCase {

    private final ExternalProductServicePort externalProductServicePort;

    public GetSimilarProductsUseCaseImplUseCase(ExternalProductServicePort externalProductServicePort) {
        this.externalProductServicePort = externalProductServicePort;
    }
}
