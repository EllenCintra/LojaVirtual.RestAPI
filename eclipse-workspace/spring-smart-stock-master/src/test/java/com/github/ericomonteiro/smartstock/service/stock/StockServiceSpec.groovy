package com.github.ericomonteiro.smartstock.service.stock

import com.github.ericomonteiro.smartstock.config.error.ErrorKeys
import com.github.ericomonteiro.smartstock.config.error.exceptions.BusinessException
import com.github.ericomonteiro.smartstock.model.Product
import com.github.ericomonteiro.smartstock.model.StockHistory
import com.github.ericomonteiro.smartstock.repository.ProductRepository
import com.github.ericomonteiro.smartstock.service.product.ProductService
import spock.lang.Specification

class StockServiceSpec extends Specification {

    var productService = Mock(ProductService)
    var productRepository = Mock(ProductRepository)

    var stockService = new StockService(productService, productRepository)
    var stockHistory = new ArrayList<StockHistory>()
    var product = new Product(PRODUCT_ID, "NAME", "DETAILS", 10.0, 15L, stockHistory, null)

    def PRODUCT_ID = 1L

    def "shall entry stock"() {
        setup:
        1 * productService.getAndValidProduct(PRODUCT_ID) >> product
        1 * productRepository.save(_ as Product) >> {Product p -> p}

        when: "do the entry in stock"
        var newProduct = stockService.registerEntry(PRODUCT_ID, 10)

        then: "the entry must be registered"
        noExceptionThrown()
        newProduct.getStock() == 25L
        newProduct.getHistory().size() == 1
    }

    def "shall withdraw"() {
        setup:
        1 * productService.getAndValidProduct(PRODUCT_ID) >> product
        1 * productRepository.save(_ as Product) >> {Product p -> p}

        when: "try to do exit stock"
        def newProduct = stockService.registerWithdraw(PRODUCT_ID, 5)

        then: "the withdraw must be registered"
        noExceptionThrown()
        newProduct.getStock() == 10L
        newProduct.getHistory().size() == 1
    }

    def "try to do withdraw greater than exists"() {
        setup: "get the product"
        1 * productService.getAndValidProduct(PRODUCT_ID) >> product

        when: "try to do exit stock"
        stockService.registerWithdraw(PRODUCT_ID, 25)

        then: "the entry must be registered"
        BusinessException exception = thrown()
        exception.errorCode == ErrorKeys.Stock.STOCK_IS_NOT_ENOUGH
    }



}
