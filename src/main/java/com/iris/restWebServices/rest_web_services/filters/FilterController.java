package com.iris.restWebServices.rest_web_services.filters;


import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilterController {



//    field1, field2 , filters out field3
    @GetMapping("/filter")
    public MappingJacksonValue getSomeObject() {
        SomeObject obj =  new SomeObject("value1", "value2", "value3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

        SimpleFilterProvider filterProvider = new SimpleFilterProvider().addFilter("filter1", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(obj);
        mapping.setFilters(filterProvider);

        return mapping;
    }

//    field2 and field3
    @GetMapping("/filter-list")
    public MappingJacksonValue getSomeObject2() {
        List<SomeObject> lst = Arrays.asList(new SomeObject("value1", "value2", "value3"), new SomeObject("value4", "value5", "value6")) ;
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        SimpleFilterProvider filterProvider = new SimpleFilterProvider().addFilter("filter1", filter);

        MappingJacksonValue   mapping = new MappingJacksonValue(lst);
        mapping.setFilters(filterProvider);
        return mapping;
    }
}
