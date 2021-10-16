package com.urlshrt.urlshortener.utils;

import org.springframework.stereotype.Service;

@Service
public interface KeyUtilService {


    String gettingKeyFromKeyGenerationService();

    void updatingDeletedKeyStatus(String key);

}
