package com.github.ericomonteiro.smartstock.model.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileResponseDto {
    private String name;
    private String type;
    private Boolean main;
}
