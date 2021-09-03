package com.github.ericomonteiro.smartstock.service.product;

import com.github.ericomonteiro.smartstock.config.error.exceptions.BusinessException;
import com.github.ericomonteiro.smartstock.config.error.exceptions.ResourceNotFoundException;
import com.github.ericomonteiro.smartstock.model.Product;
import com.github.ericomonteiro.smartstock.model.dto.product.ProductCreateDto;
import com.github.ericomonteiro.smartstock.model.dto.product.ProductDto;
import com.github.ericomonteiro.smartstock.model.dto.product.ProductWithHistoryDto;
import com.github.ericomonteiro.smartstock.model.dto.stockhistory.StockHistoryDto;
import com.github.ericomonteiro.smartstock.model.mapper.ProductMapper;
import com.github.ericomonteiro.smartstock.model.mapper.StockHistoryMapper;
import com.github.ericomonteiro.smartstock.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.github.ericomonteiro.smartstock.config.error.ErrorKeys.Product.ALREADY_PRODUCT_WITH_THIS_NAME;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final String ENTITY = "PRODUCT";

    public ProductDto insertProduct(ProductCreateDto productCreate) {
        Product productToCreate = ProductMapper.of(productCreate);
        if (hasProductByName(productToCreate.getName())) {
            throw new BusinessException(ALREADY_PRODUCT_WITH_THIS_NAME);
        }

        Product productSaved = productRepository.save(productToCreate);
        return ProductMapper.toProductDto(productSaved);
    }

    public List<ProductDto> listProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toProductDto)
                .collect(Collectors.toList());
    }

    public ProductWithHistoryDto getProduct(Long id) {
        return ProductMapper.toProductWithHistoryDto(getAndValidProduct(id));
    }

    public List<StockHistoryDto> getProductStockHistory(Long id) {
        return getAndValidProduct(id)
                .getHistory()
                .stream()
                .map(StockHistoryMapper::toStockHistoryDto)
                .collect(Collectors.toList());
    }

    public ProductDto updateProduct(Long id, ProductCreateDto productDto) {
        var productToUpdate = getAndValidProduct(id);

        if (hasProductByNameAndIdIsDifferent(productDto.getName(), id)) {
            throw new BusinessException(ALREADY_PRODUCT_WITH_THIS_NAME);
        }

        ProductMapper.merge(productToUpdate, productDto);
        return ProductMapper.toProductDto(productRepository.save(productToUpdate));
    }

    public void delete(Long id) {
        var product = getAndValidProduct(id);
        productRepository.delete(product);
    }

    private Boolean hasProductByName(String name) {
        return productRepository.findByNameIgnoreCase(name).isPresent();
    }

    private Boolean hasProductByNameAndIdIsDifferent(String name, Long id) {
        return productRepository.findByNameIgnoreCaseAndIdIsNot(name, id).isPresent();
    }

    public Product getAndValidProduct(Long id) {
        return getAndValidProduct(productRepository.findById(id), id.toString());
    }

    private Product getAndValidProduct(Optional<Product> optionalProduct, String key) {
        return optionalProduct.orElseThrow(() -> new ResourceNotFoundException(ENTITY, key));
    }
}
