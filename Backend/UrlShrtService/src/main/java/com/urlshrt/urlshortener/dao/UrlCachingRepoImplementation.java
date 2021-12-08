package com.urlshrt.urlshortener.dao;
import com.urlshrt.urlshortener.entity.UrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class UrlCachingRepoImplementation implements UrlCachingRepo {
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "URL";
    @Override
    public boolean addUrl(UrlEntity url){
        try {
            System.out.println("Saving URl to redis");
            redisTemplate.opsForHash().put(KEY, url.getShortenUrlPart(), url);
            return true;
        }catch (Exception e){
            System.out.println("Error While Saving Data To Cache");
            return false;
        }
    }
    @Override
    public UrlEntity getUrl(String shortenPart){
        return (UrlEntity) redisTemplate.opsForHash().get(KEY,shortenPart);
    }
    @Override
    public boolean deleteUrl(String shortenPart){
        try{
            redisTemplate.opsForHash().delete(KEY,shortenPart);
            return true;
        }catch (Exception e){
            System.out.println("Error While Deleting Data From Cache");
            return false;
        }
    }
    @Override
    public void updateCountInRedis(UrlEntity url){
        redisTemplate.opsForHash().put(KEY,url.getShortenUrlPart(),url);
    }
}
