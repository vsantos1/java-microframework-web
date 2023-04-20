package com.vsantos1.legacy.core.response;

import com.vsantos1.legacy.core.enums.HttpStatus;

public class StatusBuilder<T> {
    private final HttpStatus status;

    StatusBuilder(HttpStatus status) {
        this.status = status;
    }

    public ResponseBuilder<T> body(T body) {

        return new ResponseBuilder<>(status, body);
    }
}
