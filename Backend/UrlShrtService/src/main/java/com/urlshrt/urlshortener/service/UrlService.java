package com.urlshrt.urlshortener.service;

import com.urlshrt.urlshortener.entity.UrlEntity;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {
    UrlEntity addUrl(UrlEntity url);
    void updateUrlClicks(UrlEntity url);
    void deleteUrl(UrlEntity url);
    UrlEntity findUrl(String shortenUrlPart);
}

