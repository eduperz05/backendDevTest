package com.products.similar.infrastructure.adapters.client.configuration;

import com.products.similar.infrastructure.exceptions.ExternalServiceException;
import com.products.similar.infrastructure.exceptions.ProductNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return new ProductNotFoundException("Product not found.");
//        return switch (response.status()) {
//            case 404 -> new ProductNotFoundException("Product not found.");
//            case 500 -> new ExternalServiceException("Error occurred in external service.");
//            default -> new Exception("Generic error message.");
//        };
    }
}
