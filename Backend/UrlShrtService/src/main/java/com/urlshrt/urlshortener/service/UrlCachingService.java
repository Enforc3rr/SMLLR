package com.urlshrt.urlshortener.service;

import com.urlshrt.urlshortener.entity.UrlEntity;
import org.springframework.stereotype.Service;

@Service
public interface UrlCachingService {
    boolean addUrlToCache(UrlEntity url);
    boolean deleteUrlFromCacheById(String shortenUrlPart);
    UrlEntity fetchUrlFromCacheById(String shortenUrlPart);
    void updateClicksInCache(UrlEntity url);
}
