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
        urlEntity.setShortenUrlPart("some random character");
        urlEntity.setCreationDate(currentDate);
        urlEntity.setExpirationDate("Some Expiration Date");

        System.out.println(urlEntity.toString());

        urlRepo.save(urlEntity);
    }
}
