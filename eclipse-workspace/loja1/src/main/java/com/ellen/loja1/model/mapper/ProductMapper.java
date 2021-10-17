package com.ellen.loja1.model.mapper;

import com.ellen.loja1.model.Category;
import com.ellen.loja1.model.Product;
import com.ellen.loja1.model.dto.product.ProductCreateUpdateDto;

public class ProductMapper {
	
	public static void merge(Product result, ProductCreateUpdateDto from, Category categoria) {
        result.setName(from.getName());
        result.setCategoria(categoria);
        result.setDetails(from.getDetails());
        result.setPrice(from.getPrice());
    }

}
