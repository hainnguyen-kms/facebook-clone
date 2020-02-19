package com.example.facebook.dto.response;

import java.util.List;

public class SuccessRequestResponse {
    private List<Object> errors;
    private Boolean status;
    private Object data;

    public SuccessRequestResponse() {
    }

    public SuccessRequestResponse(List<Object> errors, Boolean status, Object data) {
        this.errors = errors;
        this.status = status;
        this.data = data;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
