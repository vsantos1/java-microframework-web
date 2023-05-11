package com.vsantos1.legacy.core.response;

import com.vsantos1.legacy.core.enums.HttpStatus;

import java.util.Date;

public class Error {


    private String message;

    private int status;

    private String path;

    private Date timestamp;

    public Error(String message, int status, String path, Date timestamp) {
        this.message = message;
        this.status = status;
        this.path = path;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
