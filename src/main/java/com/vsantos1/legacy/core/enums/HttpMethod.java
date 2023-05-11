package com.vsantos1.legacy.core.enums;

public enum HttpMethod {
    GET("get"),
    POST("post"),
    PUT("put"),
    DELETE("delete");

    private String method;

    HttpMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
