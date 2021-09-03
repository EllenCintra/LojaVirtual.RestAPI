package com.github.ericomonteiro.smartstock.model.dto.stockhistory;

import com.github.ericomonteiro.smartstock.model.enums.StockMovementType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StockHistoryDto {
    private Long id;
    private StockMovementType type;
    private LocalDate date;
    private Long quantity;
}
