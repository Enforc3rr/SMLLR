package com.urlshrt.urlshortener.dto;

import com.urlshrt.urlshortener.entity.UrlEntity;
import org.springframework.data.repository.CrudRepository;

public interface URLRepo extends CrudRepository<UrlEntity,Integer> {

}
