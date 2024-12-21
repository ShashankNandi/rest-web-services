package com.iris.restWebServices.rest_web_services.filters;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @GetMapping("/filter")
    public SomeObject getSomeObject() {
        return new SomeObject("value1", "value2", "value3");
    }
}
