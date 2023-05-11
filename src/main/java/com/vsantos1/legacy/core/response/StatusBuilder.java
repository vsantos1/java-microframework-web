package com.vsantos1.legacy.core.response;

import com.vsantos1.legacy.core.enums.HttpStatus;
import jakarta.servlet.http.HttpServletResponse;

public class StatusBuilder<T> {
    private final HttpStatus status;

    StatusBuilder(HttpStatus status) {
        this.status = status;
    }

    public ResponseEntity<T> body(T body) {

        return new ResponseEntity<>(status, body);
    }

    public void build(HttpServletResponse response) {
        new ResponseEntity<>(status, response).build(response);
    }
}
