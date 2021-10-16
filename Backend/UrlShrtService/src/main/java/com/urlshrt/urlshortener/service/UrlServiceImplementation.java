package com.urlshrt.urlshortener.service;

import com.urlshrt.urlshortener.dto.URLRepo;
import com.urlshrt.urlshortener.entity.UrlEntity;
import com.urlshrt.urlshortener.utils.KeyUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UrlServiceImplementation implements UrlService {
    @Autowired
    URLRepo urlRepo;
    @Autowired
    KeyUtilService keyUtilService;

    @Override
    public UrlEntity addUrl(UrlEntity url){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = simpleDateFormat.format(date);
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setMainUrl(url.getMainUrl());

        urlEntity.setShortenUrlPart(keyUtilService.gettingKeyFromKeyGenerationService());

        urlEntity.setCreationDate(currentDate);

        return urlRepo.save(urlEntity);
    }
    @Override
    public void updateUrlClicks(UrlEntity url){
        url.setNumberOfClicks(url.getNumberOfClicks()+1);
        urlRepo.save(url);
    }
    @Override
    public void deleteUrl(UrlEntity url){
        urlRepo.deleteById(url.getShortenUrlPart());
    }
    @Override
    public UrlEntity findUrl(String shortenUrlPart){
        return urlRepo.findUrl(shortenUrlPart);
    }
}
