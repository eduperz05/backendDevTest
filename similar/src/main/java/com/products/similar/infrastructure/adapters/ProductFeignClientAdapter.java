package com.products.similar.infrastructure.adapters;
import com.products.similar.application.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "product")
public interface ProductFeignClientAdapter {
    @GetMapping("/{productId}")
    ProductDTO getProductDetails(@PathVariable String productId);

    @GetMapping("/{productId}/similarids")
    List<String> getSimilarProductIds(@PathVariable String productId);
}
