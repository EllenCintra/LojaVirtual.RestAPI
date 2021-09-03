package com.github.ericomonteiro.smartstock.service.stock;

import com.github.ericomonteiro.smartstock.config.error.exceptions.BusinessException;
import com.github.ericomonteiro.smartstock.model.dto.product.ProductWithHistoryDto;
import com.github.ericomonteiro.smartstock.model.mapper.ProductMapper;
import com.github.ericomonteiro.smartstock.repository.ProductRepository;
import com.github.ericomonteiro.smartstock.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.github.ericomonteiro.smartstock.config.error.ErrorKeys.Stock.STOCK_IS_NOT_ENOUGH;

@Service
@RequiredArgsConstructor
public class StockService {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductWithHistoryDto registerEntry(Long productId, Long quantity) {
        var product = productService.getAndValidProduct(productId);
        product.registerEntry(quantity);
        return ProductMapper.toProductWithHistoryDto(productRepository.save(product));
    }

    public ProductWithHistoryDto registerWithdraw(Long productId, Long quantity) {
        var product = productService.getAndValidProduct(productId);

        if (product.getStock() < quantity) {
            throw new BusinessException(STOCK_IS_NOT_ENOUGH);
        }

        product.registerExit(quantity);
        return ProductMapper.toProductWithHistoryDto(productRepository.save(product));
    }
}
