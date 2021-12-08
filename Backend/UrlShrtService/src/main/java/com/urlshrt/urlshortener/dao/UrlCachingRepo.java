package com.urlshrt.urlshortener.dao;

import com.urlshrt.urlshortener.entity.UrlEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlCachingRepo {

    boolean addUrl(UrlEntity url);

    UrlEntity getUrl(String shortenPart);

    boolean deleteUrl(String shortenPart);

    void updateCountInRedis(UrlEntity url);

}
