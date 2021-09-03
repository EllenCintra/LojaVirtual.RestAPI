package com.github.ericomonteiro.smartstock.config.error.exceptions;

import com.github.ericomonteiro.smartstock.config.error.ErrorKeys;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class ResourceNotFoundException extends BusinessException {
    private final String entity;
    private final String key;

    public ResourceNotFoundException(String entity, String key) {
        super(ErrorKeys.General.NOT_FOUND);
        this.entity = entity;
        this.key = key;
    }
}
