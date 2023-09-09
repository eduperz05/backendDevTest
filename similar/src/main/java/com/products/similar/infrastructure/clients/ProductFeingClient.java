package com.products.similar.infrastructure.clients;
import com.products.similar.infrastructure.adapters.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product", url = "${client.product.url}")
public interface ProductFeingClient {
    @GetMapping("/{productId}")
    ResponseEntity<ProductResponse> getProductDetails(@PathVariable("productId") String productId);

    @GetMapping("/{productId}/similarids")
    ResponseEntity<List<String>> getSimilarIds(@PathVariable("productId") String productId);
}
