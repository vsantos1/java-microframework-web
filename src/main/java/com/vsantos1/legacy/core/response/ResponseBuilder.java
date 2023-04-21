package com.vsantos1.legacy.core.response;

import com.vsantos1.legacy.core.enums.ContentType;
import com.vsantos1.legacy.core.parser.Json;
import com.vsantos1.legacy.core.enums.HttpStatus;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

public class ResponseBuilder<T> {
    private final HttpStatus status;
    private static final String CHARSET_ENCODING = "UTF-8";
    private final T body;

    protected Json json;
    private final Logger logger = Logger.getLogger(ResponseBuilder.class.getName());

    ResponseBuilder(HttpStatus status, T body) {
        this.status = status;
        this.body = body;
    }

    public void build(HttpServletResponse response, ContentType contentType) throws IOException {

        this.execute(response, contentType);
    }

    protected void execute(HttpServletResponse response, ContentType contentType) throws IOException {
        response.setStatus(this.status.getValue());
        response.setContentType(contentType.getValue());
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
        new Response<>(status, body);
    }

}