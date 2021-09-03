package com.github.ericomonteiro.smartstock.model.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String details;
    private Float price;
    private Long stock;
}
