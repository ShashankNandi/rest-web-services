package com.iris.restWebServices.rest_web_services.user;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAO {

    private static List<User> users = new ArrayList<User>();
    private static int usersCount = 0;


    public UserDAO() {
        users.add(new User("jack", 1, new Date()));
        users.add(new User("ram", 2, new Date()));
        users.add(new User("clegane", 3, new Date()));
        usersCount = users.size();

    }

    public List<User> getAllUser() {
        return users;
    }

    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;

    }

    public User addUser(User user) {
//        if(user.getId()==null){
            user.setId(++usersCount);
//        }

        users.add(user);
        return user;
    }
}
