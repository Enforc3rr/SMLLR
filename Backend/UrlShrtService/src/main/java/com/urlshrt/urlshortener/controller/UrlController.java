package com.urlshrt.urlshortener.controller;

import com.urlshrt.urlshortener.entity.UrlEntity;
import com.urlshrt.urlshortener.responses.GenericResponse;
import com.urlshrt.urlshortener.service.UrlCachingService;
import com.urlshrt.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/url")
@CrossOrigin(origins = "http://localhost:3000")
public class UrlController {

    @Autowired
    UrlService urlService;

    @Autowired
    UrlCachingService urlCachingService;


    @PostMapping(value = "/add",consumes = "application/json")
    public ResponseEntity<?> addUrl(@RequestBody UrlEntity url){

        UrlEntity savedUrl = urlService.addUrl(url);

        return new ResponseEntity<>(
                new GenericResponse("You can access your URL @ http://www.smllr.com/" +
                        savedUrl.getShortenUrlPart(),true,url.getMainUrl()), HttpStatus.CREATED);
    }

    @GetMapping(value="/{shortenPart}")
    public ResponseEntity<?> getUrl(@PathVariable("shortenPart") String shortenPart){
        UrlEntity urlInCache = urlCachingService.fetchUrlFromCacheById(shortenPart);
        if(urlInCache==null){
            UrlEntity url = urlService.findUrl(shortenPart);
            if(url!=null){
                if(url.getNumberOfClicks() < 4){ //&& url.getUploadedBy.equals("anon");
                    urlService.updateUrlClicks(url);
                    return new ResponseEntity<>(new GenericResponse("URL Found",true,url.getMainUrl()),HttpStatus.OK);
                }else {
                    urlService.updateUrlClicks(url);
                    urlCachingService.addUrlToCache(url);
                    return new ResponseEntity<>(new GenericResponse("URL Found",true,url.getMainUrl()),HttpStatus.OK);
                }
            }else{
                return new ResponseEntity<>(new GenericResponse("URL Not Found",false),HttpStatus.NOT_FOUND);
            }
        }else if(urlInCache.getNumberOfClicks() >= 4 && urlInCache.getNumberOfClicks() < 9){
            // A-sync calling UpdateUrlClicks
            CompletableFuture.runAsync(()->{
                urlService.updateUrlClicks(urlInCache);
                urlCachingService.updateClicksInCache(urlInCache);
            });
            return new ResponseEntity<>(new GenericResponse("URL Found",true,urlInCache.getMainUrl()),HttpStatus.OK);
        }else{
            urlService.deleteUrl(urlInCache);
            urlCachingService.deleteUrlFromCacheById(urlInCache.getShortenUrlPart());
            return new ResponseEntity<>(new GenericResponse("URL Not Found",false),HttpStatus.NOT_FOUND);
        }
    }
}
