package com.products.similar.usecases;


import com.products.similar.application.usecase.SimilarProductsUseCase;
import com.products.similar.domain.models.Product;
import com.products.similar.domain.ports.out.ExternalProductPort;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SimilarProductsUseCaseTest {
    @Mock
    private ExternalProductPort externalProductPort;

    @InjectMocks
    private SimilarProductsUseCase similarProductsUseCase;

    @Test
    public void getSimilarProductsShouldReturnAnEmptyList() {
        when(externalProductPort.getSimilarProductIds(anyString())).thenReturn(Collections.emptyList());

        List<Product> result = similarProductsUseCase.getSimilarProducts("1");

        assertTrue(result.isEmpty());
        verify(externalProductPort, never()).getProductDetails(anyString());
    }

    @Test
    public void getSimilarProductsShouldFindAllSimilarProducts() {
        List<String> ids = Arrays.asList("1", "2");
        when(externalProductPort.getSimilarProductIds("3")).thenReturn(ids);
        when(externalProductPort.getProductDetails("1")).thenReturn(new Product());
        when(externalProductPort.getProductDetails("2")).thenReturn(new Product());

        List<Product> result = similarProductsUseCase.getSimilarProducts("3");

        assertEquals(2, result.size());
    }

    @Test
    public void getSimilarProductsShouldIgnoreNullProducts() {
        List<String> ids = Arrays.asList("1", "2");
        when(externalProductPort.getSimilarProductIds("3")).thenReturn(ids);
        when(externalProductPort.getProductDetails("1")).thenReturn(new Product());
        when(externalProductPort.getProductDetails("2")).thenReturn(null);

        List<Product> result = similarProductsUseCase.getSimilarProducts("3");

        assertEquals(1, result.size());
    }
}
