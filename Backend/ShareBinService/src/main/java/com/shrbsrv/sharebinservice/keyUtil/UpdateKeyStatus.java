package com.shrbsrv.sharebinservice.keyUtil;

public class UpdateKeyStatus {
    private String keyToUpdate;

    public UpdateKeyStatus() {
    }

    public UpdateKeyStatus(String keyToUpdate) {
        this.keyToUpdate = keyToUpdate;
    }

    public String getKeyToUpdate() {
        return keyToUpdate;
    }

    public void setKeyToUpdate(String keyToUpdate) {
        this.keyToUpdate = keyToUpdate;
    }
}
