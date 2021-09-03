package com.github.ericomonteiro.smartstock.resource.v1;

import com.github.ericomonteiro.smartstock.model.Product;
import com.github.ericomonteiro.smartstock.model.dto.product.ProductWithHistoryDto;
import com.github.ericomonteiro.smartstock.model.dto.stockhistory.StockHistoryDto;
import com.github.ericomonteiro.smartstock.repository.ProductRepository;
import com.github.ericomonteiro.smartstock.service.product.ProductService;
import lombok.AllArgsConstructor;
import com.github.ericomonteiro.smartstock.model.dto.product.ProductCreateDto;
import com.github.ericomonteiro.smartstock.model.dto.product.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/product")
@AllArgsConstructor
public class ProductResource {
    private final ProductService productService = new ProductService();
    private final ProductRepository productRepository = null;

    @GetMapping("/model")
    public List<Product> getFromModel() {
        return productRepository.findAll();
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        var result = productService.listProducts();
        if (result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductWithHistoryDto> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/{id}/history")
    public ResponseEntity<List<StockHistoryDto>> getProductStockHistory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getProductStockHistory(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable("id") Long id,
            @Valid @RequestBody ProductCreateDto productUpdate) {
        return ResponseEntity.ok(productService.updateProduct(id, productUpdate));
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductCreateDto productCreate) {
        return new ResponseEntity<>(productService.insertProduct(productCreate), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity.BodyBuilder deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok();
    }

}