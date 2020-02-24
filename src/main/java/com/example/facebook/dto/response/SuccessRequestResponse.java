package com.example.facebook.dto.response;

import java.util.List;

public class SuccessRequestResponse {
    private List<Object> errors;
    private Integer status;
    private Object data;

    public SuccessRequestResponse() {
    }

    public SuccessRequestResponse(List<Object> errors, Integer status, Object data) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
