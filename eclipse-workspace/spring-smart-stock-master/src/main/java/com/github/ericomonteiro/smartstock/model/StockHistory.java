package com.github.ericomonteiro.smartstock.model;

import com.github.ericomonteiro.smartstock.model.enums.StockMovementType;
import com.github.ericomonteiro.smartstock.model.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockHistory {

    public StockHistory(Product product, StockMovementType type, Long quantity) {
        this.product = product;
        this.type = type;
        this.quantity = quantity;
        this.date = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Product product;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StockMovementType type;

    @Column(nullable = false)
    private LocalDate date = LocalDate.now();

    @Column(nullable = false)
    private Long quantity;
}
