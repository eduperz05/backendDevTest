package com.products.similar.infrastructure.adapters;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponse(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("price") int price,
        @JsonProperty("availability") boolean availability
) {}
