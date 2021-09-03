package com.github.ericomonteiro.smartstock.config.error;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import java.util.Collections;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
@RequiredArgsConstructor(access = PRIVATE)
@ToString
public class ErrorResponse {
    private final int statusCode;
    private final List<ApiError> errors;

    static ErrorResponse of(HttpStatus status, List<ApiError> errors) {
        return new ErrorResponse(status.value(), errors);
    }

    static ErrorResponse of(HttpStatus status, ApiError error) {
        return of(status, Collections.singletonList(error));
    }

    @JsonAutoDetect(fieldVisibility = ANY)
    @RequiredArgsConstructor
    @ToString
    static class ApiError {
        private final String code;
        private final String message;
    }
}
