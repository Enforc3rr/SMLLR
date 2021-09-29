package com.urlshrt.urlshortener.dto;

import com.urlshrt.urlshortener.entity.UrlEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface URLRepo extends CrudRepository<UrlEntity,String> {

      @Query(nativeQuery = true , value = "SELECT * FROM URL_ENTITY WHERE SHORTEN_URL_PART= ?1")
      UrlEntity findUrl(String shortenPart);
}
