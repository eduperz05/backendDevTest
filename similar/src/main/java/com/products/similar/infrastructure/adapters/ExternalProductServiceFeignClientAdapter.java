package com.products.similar.infrastructure.adapters;
import com.products.similar.domain.models.Product;
import com.products.similar.domain.ports.out.ExternalProductServicePort;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product", url = "${client.product.url}")
public interface ExternalProductServiceFeignClientAdapter extends ExternalProductServicePort {
    @GetMapping("/{productId}")
    Product getProductDetails(@PathVariable("productId") String productId);

    @GetMapping("/{productId}/similarids")
    List<String> getSimilarProductIds(@PathVariable("productId") String productId);
}
