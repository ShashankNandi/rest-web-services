package com.iris.restWebServices.rest_web_services.user;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*; // Static import for convenience


import com.iris.restWebServices.rest_web_services.Exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public EntityModel<User> getUserById(@PathVariable int id) {

        User user =userDAO.getUser(id);
        if(user==null) {
            throw new UserNotFoundException("id - " + id);
        }else {
            // Create the EntityModel and add self link
            EntityModel<User> entityModel = EntityModel.of(user);
//
//            // Build the self link
//            entityModel.add(linkTo(methodOn(UserController.class).getUserById(id)).withSelfRel());

            // Add other links as needed (e.g., link to all users)
            entityModel.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("get-all-users"));
            return entityModel;
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
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userDAO.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{Id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
