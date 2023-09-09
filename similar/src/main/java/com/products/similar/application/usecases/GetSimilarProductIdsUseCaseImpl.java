package com.products.similar.application.usecases;

import com.products.similar.domain.ports.in.GetSimilarProductIdsUseCase;
import com.products.similar.domain.ports.out.ExternalProductServicePort;

import java.util.List;

public class GetSimilarProductIdsUseCaseImpl implements GetSimilarProductIdsUseCase {

    private final ExternalProductServicePort externalProductServicePort;

    public GetSimilarProductIdsUseCaseImpl(ExternalProductServicePort externalProductServicePort) {
        this.externalProductServicePort = externalProductServicePort;
    }

    @Override
    public List<String> getSimilarProductIds(String id) {
        return externalProductServicePort.getSimilarProductIds(id);
    }
}
