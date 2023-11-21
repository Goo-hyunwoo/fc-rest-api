package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {

    @GetMapping("")
    public UserRequest user() {
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(30);
        user.setEmail("user@gmail.com");
        return user;
    }

    @GetMapping("/code")
    public ResponseEntity returnCode() {
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(30);
        user.setEmail("user@gmail.com");

        var response = ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("x-custom", "hi")
                .body(user);

        return response;
    }
}
