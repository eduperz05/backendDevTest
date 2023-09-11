package com.products.similar.infrastructure.controllers;


import com.products.similar.application.dto.ProductDTO;
import com.products.similar.application.services.ProductService;
import com.products.similar.infrastructure.exceptions.ProductNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Get similar products by product ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "Product not found")
            })
    public ResponseEntity<List<ProductDTO>> getSimilarProducts(@PathVariable String productId){
        try {
            List<ProductDTO> similarProducts = productService.getSimilarProducts(productId);
            if(similarProducts.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(similarProducts);
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}


