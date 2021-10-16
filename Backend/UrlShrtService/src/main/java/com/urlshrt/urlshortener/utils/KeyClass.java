package com.urlshrt.urlshortener.utils;


public class KeyClass{
    private String success;
    private String key;

    public KeyClass() {
    }

    public KeyClass(String success, String key) {
        this.success = success;
        this.key = key;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "KeyClass{" +
                "success='" + success + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
