package com.products.similar.application.mapper;

import com.products.similar.application.dto.ProductDTO;
import com.products.similar.domain.models.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class productMapper {
    private final ModelMapper modelMapper;

    public Product toProduct(ProductDTO dto) {
        return modelMapper.map(dto, Product.class);
    }

    public ProductDTO toProductDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }
}
