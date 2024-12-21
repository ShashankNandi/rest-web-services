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
import java.util.Optional;

@RestController
public class UserJpaController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/jpa/users")
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }


    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> getUserById(@PathVariable int id) {

        Optional<User> user =userRepository.findById(id);
        if(!user.isPresent()) {
            throw new UserNotFoundException("id - " + id);
        }else {
            // Create the EntityModel and add self link
            EntityModel<User> entityModel = EntityModel.of(user.get());
//
//            // Build the self link
//            entityModel.add(linkTo(methodOn(UserController.class).getUserById(id)).withSelfRel());

            // Add other links as needed (e.g., link to all users)
            entityModel.add(linkTo(methodOn(UserJpaController.class).getAllUsers()).withRel("get-all-users"));
            return entityModel;
        }

    }

    @DeleteMapping("jpa/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        if(!userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build(); //return 204 on successfiull deletion
        }else{
            throw new UserNotFoundException("id - " + id);
        }

    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{Id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}