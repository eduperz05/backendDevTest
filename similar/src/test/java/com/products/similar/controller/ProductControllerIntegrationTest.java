package com.products.similar.controller;

import com.products.similar.application.dto.ProductDTO;
import com.products.similar.infrastructure.adapters.client.ProductFeignClientAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductFeignClientAdapter productFeignClientAdapter;

    @Test
    public void getSimilarProductsTest() throws Exception {
        
        List<String> similarProductIds = Arrays.asList("1", "2", "3");

        when(productFeignClientAdapter.getSimilarProductIds("4")).thenReturn(similarProductIds);
        when(productFeignClientAdapter.getProductDetails("1")).thenReturn(new ProductDTO("1", "Product1", 10.0, true));
        when(productFeignClientAdapter.getProductDetails("2")).thenReturn(new ProductDTO("2", "Product2", 20.0, true));
        when(productFeignClientAdapter.getProductDetails("3")).thenReturn(new ProductDTO("3", "Product3", 30.0, true));

        mockMvc.perform(MockMvcRequestBuilders.get("/product/{productId}/similar", "4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{" +
                        "'id':'1'," +
                        "'name':'Product1'," +
                        "'price':10.0,'availability':true" +"}," + "{" +
                        "'id':'2'," +
                        "'name':'Product2'," +
                        "'price':20.0," +
                        "'availability':true" +"}," + "{" +
                        "'id':'3'," +
                        "'name':'Product3'," +
                        "'price':30.0," +
                        "'availability':true" +
                        "}]"));
    }

    @Test
    public void NotFoundTest() throws Exception {
        String productId = "1";
        when(productFeignClientAdapter.getSimilarProductIds(productId)).thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/product/{productId}/similar", productId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}