package com.urlshrt.urlshortener.responses;

public class GenericResponse {
    private String message;
    private boolean status;
    private String url;

    public GenericResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public GenericResponse(boolean status, String url) {
        this.status = status;
        this.url = url;
    }

    public GenericResponse(String message, boolean status, String url) {
        this.message = message;
        this.status = status;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
