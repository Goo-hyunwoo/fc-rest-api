package com.example.restapi.controller;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    // json
    /*
    {
        "name": "IT",
        "category": "java",
        "number": 132
    }
    number는 숫자지만 json의 숫자는 문자열로 자동 변환됨
     */
    @PostMapping("/post")
    public BookRequest post(@RequestBody BookRequest bookRequest) {
        System.out.println(bookRequest);
        return bookRequest;
    }

    @PostMapping("/user")
    public UserRequest user(@RequestBody UserRequest userRequest) {
        System.out.println(userRequest);
        return userRequest;
    }
}
