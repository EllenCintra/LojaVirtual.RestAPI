package com.github.ericomonteiro.smartstock.model.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import static com.github.ericomonteiro.smartstock.config.error.ErrorKeys.Product.NAME_NOT_BLANK;
import static com.github.ericomonteiro.smartstock.config.error.ErrorKeys.Product.DETAIL_NOT_BLANK;
import static com.github.ericomonteiro.smartstock.config.error.ErrorKeys.Product.PRICE_MUST_GREATER_ZERO;
import static com.github.ericomonteiro.smartstock.config.error.ErrorKeys.Product.PRICE_NOT_NULL;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {
    @NotBlank(message = NAME_NOT_BLANK)
    private String name;

    @NotBlank(message = DETAIL_NOT_BLANK)
    private String details;

    @Positive(message = PRICE_MUST_GREATER_ZERO)
    @NotNull(message = PRICE_NOT_NULL)
    private Float price;
}
