package com.urlshrt.urlshortener.service;

import com.urlshrt.urlshortener.dao.UrlCachingRepo;
import com.urlshrt.urlshortener.entity.UrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlCachingServiceImplementation implements UrlCachingService{
    @Autowired
    UrlCachingRepo urlCachingRepo;

    @Override
    public boolean addUrlToCache(UrlEntity url) {
        return urlCachingRepo.addUrl(url);
    }

    @Override
    public boolean deleteUrlFromCacheById(String shortenUrlPart) {
        return urlCachingRepo.deleteUrl(shortenUrlPart);
    }

    @Override
    public UrlEntity fetchUrlFromCacheById(String shortenUrlPart) {
        return urlCachingRepo.getUrl(shortenUrlPart);
    }

    @Override
    public void updateClicksInCache(UrlEntity url) {
        urlCachingRepo.updateCountInRedis(url);
    }
}
