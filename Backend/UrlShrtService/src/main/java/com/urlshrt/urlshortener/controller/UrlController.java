package com.urlshrt.urlshortener.controller;

import com.urlshrt.urlshortener.entity.UrlEntity;
import com.urlshrt.urlshortener.responses.GenericResponse;
import com.urlshrt.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping(value = "/url/add",consumes = "application/json")
    public ResponseEntity<?> addUrl(@RequestBody UrlEntity url){

        urlService.addUrl(url);

        return new ResponseEntity<>(
                new GenericResponse("URL successfully Added",true), HttpStatus.CREATED);
    }

    @GetMapping(value="/{shortenPart}")
    public ResponseEntity<?> getUrl(@PathVariable String shortenPart){
        String url = urlService.findUrl(shortenPart);

        if(url!=null){
            return new ResponseEntity<>(new GenericResponse("URL Found",true,url),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new GenericResponse("URL Not Found",false),HttpStatus.BAD_REQUEST);
        }

    }

}
