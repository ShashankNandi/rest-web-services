package com.iris.restWebServices.rest_web_services.user;

import com.iris.restWebServices.rest_web_services.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

        User user =userDAO.getUser(id);
        if(user==null) {
            throw new UserNotFoundException("id - " + id);
        }else {
            return user;
        }

    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        boolean userRemoved = userDAO.deleteUser(id);

        if(userRemoved) {
            return ResponseEntity.noContent().build(); //return 204 on successfiull deletion
        }else{
            throw new UserNotFoundException("id - " + id);
        }

    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userDAO.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{Id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
