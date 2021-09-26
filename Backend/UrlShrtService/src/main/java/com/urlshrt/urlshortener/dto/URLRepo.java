package com.urlshrt.urlshortener.dto;

import com.urlshrt.urlshortener.entity.UrlEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface URLRepo extends CrudRepository<UrlEntity,Integer> {

      @Query(nativeQuery = true , value = "SELECT MAIN_URL FROM URL_ENTITY WHERE SHORTEN_URL_PART= ?1")
      String findUrl(String shortenPart);
}
