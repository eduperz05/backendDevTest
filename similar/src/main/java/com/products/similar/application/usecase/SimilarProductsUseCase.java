package com.products.similar.application.usecase;

import com.products.similar.domain.models.Product;
import com.products.similar.domain.ports.in.SimilarProductsPort;
import com.products.similar.domain.ports.out.ExternalProductPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SimilarProductsUseCase implements SimilarProductsPort {

    private final ExternalProductPort externalProductPort;

    @Override
    public List<Product> getSimilarProducts(String id) {
        List<String> similarProductIds = externalProductPort.getSimilarProductIds(id);
        return similarProductIds.stream()
                .map(externalProductPort::getProductDetails)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
