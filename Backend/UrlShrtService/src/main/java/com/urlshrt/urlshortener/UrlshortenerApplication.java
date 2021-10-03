package com.urlshrt.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UrlshortenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlshortenerApplication.class, args);
    }

}
