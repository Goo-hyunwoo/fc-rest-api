package com.example.restapi.controller;

import com.example.restapi.model.Api;
import com.example.restapi.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.AccessException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private static List<UserResponse> userList = List.of(
            UserResponse.builder()
                    .id("1")
                    .age(10)
                    .name("홍길동")
                    .build(),
            UserResponse.builder()
                    .id("2")
                    .age(13)
                    .name("유관순")
                    .build()
    );

    @GetMapping("/id/{userId}")
    public Api<UserResponse> getUser(@PathVariable String userId) {
        if(userId.equals("3")) {
            throw new RuntimeException("런타임");
        }

        var user = userList.stream()
                .filter(it -> it.getId().equals(userId))
                .findFirst()
                .get();

        Api<UserResponse> response = Api.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(user)
                .build();

        return response;
    }
}
