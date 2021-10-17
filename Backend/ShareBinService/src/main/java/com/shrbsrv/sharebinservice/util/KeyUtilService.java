package com.shrbsrv.sharebinservice.util;

import org.springframework.stereotype.Service;

@Service
public interface KeyUtilService {
    String gettingKeyFromKeyGenerationService();
    void updatingDeletedKeyStatus(String key);
}