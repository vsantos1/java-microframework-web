package com.vsantos1.legacy.core.response;

import com.vsantos1.legacy.core.enums.HttpStatus;
import com.vsantos1.legacy.core.parser.Json;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ResponseEntity<T> {
    private final HttpStatus status;
    private static final String CHARSET_ENCODING = "UTF-8";
    private final T body;

    protected Json json;

    ResponseEntity(HttpStatus status, T body) {
        this.status = status;
        this.body = body;
    }

    public void build(HttpServletResponse response) {
        try {
            this.execute(response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    protected void execute(HttpServletResponse response) throws IOException {
        response.setStatus(this.status.getValue());
        response.setCharacterEncoding(CHARSET_ENCODING);


        if (this.status == HttpStatus.NO_CONTENT || this.body == null) {
            return;
        }

        if (this.body instanceof byte[]) {
            response.getOutputStream().write((byte[]) this.body);
            response.getOutputStream().close();
            return;
        }

        response.getWriter().write(Json.parseToJson(this.body));
        response.getWriter().close();
    }

}