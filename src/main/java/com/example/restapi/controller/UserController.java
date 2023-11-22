package com.example.restapi.controller;

import com.example.restapi.model.Api;
import com.example.restapi.model.UserRegistRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/reg")
public class UserController {

    @PostMapping("")
    public Api<UserRegistRequest> register(
            @Valid
            @RequestBody Api<UserRegistRequest> userRegistRequest

    ) {

        log.info("init {}", userRegistRequest);

        var body = userRegistRequest.getData();
        Api<UserRegistRequest> response = Api.<UserRegistRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(body)
                .build();
        return response;
    }
}
