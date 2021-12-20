package com.movies.moviesapp.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class ResourceService {

    @Autowired
    private ResourceLoader resourceLoader;

    public Resource readDataResource() {
        return resourceLoader.getResource("classpath:openapi.json");
    }

    public String readDataResourceAsString() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:openapi.json");
        InputStream inputStream = resource.getInputStream();
        byte[] fileData = FileCopyUtils.copyToByteArray(inputStream);
        return new String(fileData);
    }
}