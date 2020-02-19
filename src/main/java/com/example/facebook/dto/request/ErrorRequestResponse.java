package com.example.facebook.dto.request;

public class ErrorRequestResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorRequestResponse() {
    }

    public ErrorRequestResponse(String message) {
        this.message = message;
    }
}
