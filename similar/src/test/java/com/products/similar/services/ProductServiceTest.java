package com.products.similar.services;


import com.products.similar.application.dto.ProductDTO;
import com.products.similar.application.services.ProductService;
import com.products.similar.application.usecase.SimilarProductsUseCase;
import com.products.similar.domain.models.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private SimilarProductsUseCase similarProductsUseCase;

    @InjectMocks
    private ProductService productService;


    @Test
    public void testGetSimilarProducts_withProducts() {
        Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);

        when(similarProductsUseCase.getSimilarProducts("1"))
                .thenReturn(Arrays.asList(product1, product2));

        List<ProductDTO> result = productService.getSimilarProducts("1");

        assertEquals(2, result.size());
    }

    @Test
    public void testGetSimilarProducts_emptyList() {
        when(similarProductsUseCase.getSimilarProducts("1"))
                .thenReturn(Collections.emptyList());

        List<ProductDTO> result = productService.getSimilarProducts("1");

        assertTrue(result.isEmpty());
    }

}
