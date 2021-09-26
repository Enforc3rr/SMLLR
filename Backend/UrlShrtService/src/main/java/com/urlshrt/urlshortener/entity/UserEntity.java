package com.urlshrt.urlshortener.entity;

import java.util.ArrayList;

public class UserEntity {
    private int userId;
    private String username;
    private String password;
    private ArrayList<UrlEntity> listOfCustomUrlEntity;

    public UserEntity() {
    }

    public UserEntity(String username, String password, ArrayList<UrlEntity> listOfCustomUrlEntity) {
        this.username = username;
        this.password = password;
        this.listOfCustomUrlEntity = listOfCustomUrlEntity;
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<UrlEntity> getListOfCustomURL() {
        return listOfCustomUrlEntity;
    }

    public void setListOfCustomURL(ArrayList<UrlEntity> listOfCustomUrlEntity) {
        this.listOfCustomUrlEntity = listOfCustomUrlEntity;
    }
}
