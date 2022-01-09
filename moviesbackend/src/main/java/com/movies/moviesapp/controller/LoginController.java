package com.movies.moviesapp.controller;

import com.movies.moviesapp.controller.response.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class LoginController {

    @GetMapping(value = "/database")
    public ResponseEntity<ResponseDTO> privateEndpoint() {
        return ResponseEntity.ok(new ResponseDTO("pass"));
    }

}
