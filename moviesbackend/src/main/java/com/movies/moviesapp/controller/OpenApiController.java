package com.movies.moviesapp.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.movies.moviesapp.service.impl.ResourceService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/openapi")
public class OpenApiController {


    @Autowired
    private ResourceService resourceService;

    /**
     * Returns OpenAPI specification.
     *
     * @return Documentation of API
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Resource loadEmployeesWithResourceLoader() throws IOException {

        String openApi = resourceService.readDataResourceAsString();
        Resource openApi2 = resourceService.readDataResource();


        BasicJsonParser parser = new BasicJsonParser();
        JSONParser jsonObject = new JSONParser(openApi);

        return openApi2;
    }

}
