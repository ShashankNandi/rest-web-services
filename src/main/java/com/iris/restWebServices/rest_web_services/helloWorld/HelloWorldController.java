package com.iris.restWebServices.rest_web_services.helloWorld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }


    @GetMapping("/hello-world/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {

        return new HelloWorldBean(  String.format("Hello %s!", name));

    }
}
