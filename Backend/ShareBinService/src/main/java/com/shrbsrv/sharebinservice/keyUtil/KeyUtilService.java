package com.shrbsrv.sharebinservice.keyUtil;

import org.springframework.stereotype.Service;

@Service
public interface KeyUtilService {
    String gettingKeyFromKeyGenerationService();
    void updatingDeletedKeyStatus(String key);
}