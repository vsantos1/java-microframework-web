package com.vsantos1.legacy.core.response;

import com.vsantos1.legacy.core.enums.HttpStatus;


public class Response<T> {
    private final HttpStatus status;
    private final T body;

    Response(HttpStatus status, T body) {
        this.status = status;
        this.body = body;
    }

    public static <T> StatusBuilder<T> status(HttpStatus status) {
        return new StatusBuilder<>(status);
    }

    public int getStatus() {
        return status.getValue();
    }

    public T getBody() {
        return body;
    }


}