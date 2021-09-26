package com.urlshrt.urlshortener.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UrlEntity {
    @Id
    private int id ;

    private String mainUrl;
    private String shortenUrlPart;
    private String expirationDate;
    private String creationDate;

    //private User madeBy;

    public UrlEntity(){}

    public UrlEntity(String mainUrl) {
        this.mainUrl = mainUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "UrlEntity{" +
                "id=" + id +
                ", mainUrl='" + mainUrl + '\'' +
                ", shortenUrlPart='" + shortenUrlPart + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
