package com.iris.restWebServices.rest_web_services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;


    @GetMapping("/users/get-all-users")
    public List<User> getAllUsers() {
        return userDAO.getAllUser();
    }


    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userDAO.getUser(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        userDAO.addUser(user);
        return user;
    }

}
