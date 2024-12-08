package com.iris.restWebServices.rest_web_services.user;

import java.security.PrivateKey;
import java.util.Date;

public class User {

    private String username;
    private int id;
    private Date birthDate;

    public User(String username, int id, Date birthDate) {
        this.username = username;
        this.id = id;
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", birthDate=" + birthDate +
                '}';
    }
}
