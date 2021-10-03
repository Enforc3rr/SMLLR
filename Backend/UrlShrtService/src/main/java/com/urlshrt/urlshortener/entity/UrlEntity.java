package com.urlshrt.urlshortener.entity;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UrlEntity implements Serializable {
    @Id
    private String shortenUrlPart;

    private String mainUrl;
    private String creationDate;
    private int numberOfClicks;

    //private User madeBy;

    public UrlEntity(){}

    public UrlEntity(String mainUrl) {
        this.mainUrl = mainUrl;
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public void setMainUrl(String mainUrl) {
        this.mainUrl = mainUrl;
    }

    public String getShortenUrlPart() {
        return shortenUrlPart;
    }

    public void setShortenUrlPart(String shortenUrlPart) {
        this.shortenUrlPart = shortenUrlPart;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getNumberOfClicks() {
        return numberOfClicks;
    }

    public void setNumberOfClicks(int numberOfClicks) {
        this.numberOfClicks = numberOfClicks;
    }

    @Override
    public String toString() {
        return "UrlEntity{" +
                ", mainUrl='" + mainUrl + '\'' +
                ", shortenUrlPart='" + shortenUrlPart + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", numberOfClicks=" + numberOfClicks +
                '}';
    }
}
