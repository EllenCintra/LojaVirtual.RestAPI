package com.github.ericomonteiro.smartstock.model.dto.product;

import com.github.ericomonteiro.smartstock.model.dto.stockhistory.StockHistoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductWithHistoryDto {
    private Long id;
    private String name;
    private String details;
    private Float price;
    private Long stock;
    private List<StockHistoryDto> history;
}
