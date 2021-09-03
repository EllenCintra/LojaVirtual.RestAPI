package com.github.ericomonteiro.smartstock.model.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum StockMovementType {
    ENTRY("ENTRY"), EXIT("EXIT");

    private final String stockMovementType;

    private StockMovementType(String type) {
        this.stockMovementType = type;
    }

    public static StockMovementType of(String type) {
        return Stream.of(StockMovementType.values())
                .filter(p -> p.getStockMovementType().equals(type))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
