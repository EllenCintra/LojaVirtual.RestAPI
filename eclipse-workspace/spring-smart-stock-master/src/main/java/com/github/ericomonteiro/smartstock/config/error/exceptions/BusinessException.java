package com.github.ericomonteiro.smartstock.config.error.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BusinessException extends RuntimeException {
    private final String errorCode;
}
