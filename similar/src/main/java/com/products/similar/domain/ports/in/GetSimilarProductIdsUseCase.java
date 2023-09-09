package com.products.similar.domain.ports.in;

import java.util.List;

public interface GetSimilarProductIdsUseCase {
    List<String> getSimilarProductIds(String id);
}
