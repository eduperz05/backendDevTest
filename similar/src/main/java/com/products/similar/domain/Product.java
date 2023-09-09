package com.products.similar.domain;

import lombok.Data;

@Data
public class Product {

    private String id;
    private String name;
    private int price;
    private boolean availability;
}
