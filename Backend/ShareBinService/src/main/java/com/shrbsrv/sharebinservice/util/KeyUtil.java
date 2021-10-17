package com.shrbsrv.sharebinservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


@Service
public class KeyUtil implements KeyUtilService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String gettingKeyFromKeyGenerationService(){
        String url = "http://localhost:8000/key/getkeys";
        // In the future , Will try to implement something for null value.
        return restTemplate.getForObject(url,KeyClass.class).getKey();
    }

    @Override
    public void updatingDeletedKeyStatus(String key){
        String url = "http://localhost:8000/key/updateStatus";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("keyToUpdate",key);

        HttpEntity<HashMap<String,String>> httpEntity = new HttpEntity<>(hashMap,httpHeaders);

        restTemplate.postForObject(url,httpEntity,UpdateKeyStatus.class);
    }
}