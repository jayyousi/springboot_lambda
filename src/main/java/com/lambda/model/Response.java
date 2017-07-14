package com.lambda.model;

public class Response {

    public enum Status {
        OK, ERROR;
    }

    private String message;
    private Status status;

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}
