package com.products.similar.infrastructure.controllers;


import com.products.similar.application.services.ProductService;
import com.products.similar.domain.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}/similar")
    public ResponseEntity<List<Product>> getSimilarProducts(@PathVariable String productId){
        List<Product> similarProducts = productService.getSimilarProducts(productId);
        if(similarProducts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(similarProducts);
    }

}


