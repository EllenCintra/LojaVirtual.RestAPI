package com.github.ericomonteiro.smartstock.model.mapper;

import com.github.ericomonteiro.smartstock.model.StockHistory;
import com.github.ericomonteiro.smartstock.model.dto.stockhistory.StockHistoryDto;

public class StockHistoryMapper {

    public static StockHistoryDto toStockHistoryDto(StockHistory stockHistory) {
        return new StockHistoryDto(
                stockHistory.getId(),
                stockHistory.getType(),
                stockHistory.getDate(),
                stockHistory.getQuantity()
        );
    }

}
