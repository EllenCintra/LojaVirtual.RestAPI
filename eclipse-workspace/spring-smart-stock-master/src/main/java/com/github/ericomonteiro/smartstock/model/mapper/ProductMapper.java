package com.github.ericomonteiro.smartstock.model.mapper;

import com.github.ericomonteiro.smartstock.model.Product;
import com.github.ericomonteiro.smartstock.model.dto.product.ProductCreateDto;
import com.github.ericomonteiro.smartstock.model.dto.product.ProductDto;
import com.github.ericomonteiro.smartstock.model.dto.product.ProductWithHistoryDto;

import java.util.stream.Collectors;

public class ProductMapper {

    public static void merge(Product result, ProductCreateDto from) {
        result.setName(from.getName());
        result.setDetails(from.getDetails());
        result.setPrice(from.getPrice());
    }

    public static Product of(ProductCreateDto o) {
        return new Product(0L, o.getName().trim(), o.getDetails().trim(), o.getPrice());
    }

    public static ProductDto toProductDto(Product p) {
        return new ProductDto(p.getId(), p.getName(), p.getDetails(), p.getPrice(), p.getStock());
    }

    public static ProductWithHistoryDto toProductWithHistoryDto(Product p) {
        return new ProductWithHistoryDto(
                p.getId(),
                p.getName(),
                p.getDetails(),
                p.getPrice(),
                p.getStock(),
                p.getHistory().stream().map(StockHistoryMapper::toStockHistoryDto).collect(Collectors.toList())
        );
    }

}
