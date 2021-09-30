package com.urlshrt.urlshortener.controller;

import com.urlshrt.urlshortener.entity.UrlEntity;
import com.urlshrt.urlshortener.responses.GenericResponse;
import com.urlshrt.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/url")
@CrossOrigin(origins = "http://localhost:3000")
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping(value = "/add",consumes = "application/json")
    public ResponseEntity<?> addUrl(@RequestBody UrlEntity url){

        UrlEntity savedUrl = urlService.addUrl(url);

        return new ResponseEntity<>(
                new GenericResponse("You can access your URL @ http://www.smllr.com/" + savedUrl.getShortenUrlPart(),true,url.getMainUrl()), HttpStatus.CREATED);
    }

    @GetMapping(value="/{shortenPart}")
    public ResponseEntity<?> getUrl(@PathVariable String shortenPart){
        UrlEntity url = urlService.findUrl(shortenPart);
        if(url!=null){
            if(url.getNumberOfClicks() < 9){ //&& url.getUploadedBy.equals("anon");
                urlService.updateUrlClicks(url);
                return new ResponseEntity<>(new GenericResponse("URL Found",true,url.getMainUrl()),HttpStatus.OK);
            }else{
                urlService.deleteUrl(url);
                return new ResponseEntity<>(new GenericResponse("URL Not Found",false,url.getMainUrl()),HttpStatus.NOT_FOUND);
            }
        }else{
            System.out.println("Reached Here");
            return new ResponseEntity<>(new GenericResponse("URL Not Found",false),HttpStatus.NOT_FOUND);
        }
    }

}
