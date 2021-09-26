package com.urlshrt.urlshortener.service;

import com.urlshrt.urlshortener.dto.URLRepo;
import com.urlshrt.urlshortener.entity.UrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UrlService {
    @Autowired
    URLRepo urlRepo;

    public void addUrl(UrlEntity url){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = simpleDateFormat.format(date);

        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setMainUrl(url.getMainUrl());
        urlEntity.setShortenUrlPart("random");
        urlEntity.setCreationDate(currentDate);
        urlEntity.setExpirationDate("Some Expiration Date");

        urlRepo.save(urlEntity);

//        urlRepo.save(urlEntity);
    }

    public String findUrl(String shortenUrlPart){
        return urlRepo.findUrl(shortenUrlPart);
    }
}
