package com.iris.restWebServices.rest_web_services.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.security.PrivateKey;
import java.util.Date;

public class User {

    @Size(min = 2, message = "name should be of mininmum 2 chars")
    private String username;

    private Integer id;
    @Past
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

    public Integer getId() {
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
