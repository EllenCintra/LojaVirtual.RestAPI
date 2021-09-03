package com.github.ericomonteiro.smartstock.model.dto.photo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AlbumDto {
    private String uri;
    private Boolean main;
}

