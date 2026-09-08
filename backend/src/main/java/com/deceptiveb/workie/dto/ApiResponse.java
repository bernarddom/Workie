package com.deceptiveb.workie.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ApiResponse implements Serializable {
    @Serial
    @JsonIgnore
    private static final long serialVersionUID = 7702134516418182840L;

    private Boolean success;

    private String message;

    private int status;

    private Map<String, String> errors;

    public ApiResponse() {

    }

    public ApiResponse(Boolean success, String message, int status) {
        this.success = success;
        this.message = message;
        this.status = status;
    }

    public ApiResponse(Boolean success, String message, int status, Map<String, String> errors) {
        this.success = success;
        this.message = message;
        this.status = status;
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
