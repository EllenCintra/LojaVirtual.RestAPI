package com.github.ericomonteiro.smartstock.model.mapper

import com.github.ericomonteiro.smartstock.model.Product
import com.github.ericomonteiro.smartstock.model.dto.product.ProductCreateDto
import spock.lang.Specification

class ProductMapperSpec extends Specification {

    def productMapper = new ProductMapper()

    def "shall convert a ProductCreateDto to Product"() {
        when: "convert a product create dto to product"
        def fromDto = new ProductCreateDto("NAME", "DETAILS", 15.5)
        def product = productMapper.of(fromDto)

        then: "expect a product model equals the dto"
        product.getId() == 0L
        product.getName() == fromDto.getName()
        product.getDetails() == fromDto.getDetails()
        product.getPrice() == fromDto.getPrice()
    }

//    def "shall convert a Product to ProductDto"() {
//        when: "convert a Product to ProductDto"
//        def from = new Product(1L, "NAME", "DETAILS", 15.5)
//        def productDto = productMapper.toProductDto(from)
//
//        then: "expect a product model equals the dto"
//        productDto.getId() == from.getId()
//        productDto.getName() == from.getName()
//        productDto.getDetails() == from.getDetails()
//        productDto.getPrice() == from.getPrice()
//    }

}
