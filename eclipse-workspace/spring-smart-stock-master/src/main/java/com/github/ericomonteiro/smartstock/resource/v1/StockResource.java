package com.github.ericomonteiro.smartstock.resource.v1;

import com.github.ericomonteiro.smartstock.model.dto.product.ProductWithHistoryDto;
import com.github.ericomonteiro.smartstock.service.stock.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/stock")
public class StockResource {
    private final StockService stockService;

    @PostMapping("/{productId}/entry/{quantity}")
    public ResponseEntity<ProductWithHistoryDto> entryStock(@PathVariable Long productId, @PathVariable Long quantity) {
        return ResponseEntity.ok(stockService.registerEntry(productId, quantity));
    }

    @PostMapping("/{productId}/withdraw/{quantity}")
    public ResponseEntity<ProductWithHistoryDto> withdrawStock(@PathVariable Long productId, @PathVariable Long quantity) {
        return ResponseEntity.ok(stockService.registerWithdraw(productId, quantity));
    }


}
