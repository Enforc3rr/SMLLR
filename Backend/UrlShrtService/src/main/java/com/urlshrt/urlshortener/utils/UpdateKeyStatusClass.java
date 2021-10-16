package com.urlshrt.urlshortener.utils;

public class UpdateKeyStatusClass {
    private String keyToUpdate;

    public UpdateKeyStatusClass(String keyToUpdate) {
        this.keyToUpdate = keyToUpdate;
    }

    public UpdateKeyStatusClass() {
    }

    public String getKeyToUpdate() {
        return keyToUpdate;
    }

    public void setKeyToUpdate(String keyToUpdate) {
        this.keyToUpdate = keyToUpdate;
    }
}
