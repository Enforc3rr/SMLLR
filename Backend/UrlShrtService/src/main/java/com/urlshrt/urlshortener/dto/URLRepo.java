package com.urlshrt.urlshortener.dto;

import com.urlshrt.urlshortener.entity.UrlEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface URLRepo extends CrudRepository<UrlEntity,String> {

      @Query(nativeQuery = true , value = "SELECT * FROM smllr WHERE shorten_url_part= ?1")
      UrlEntity findUrl(String shortenPart);
}
