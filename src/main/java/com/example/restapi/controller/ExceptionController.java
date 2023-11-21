package com.example.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/ex")
public class ExceptionController {

    @GetMapping("")
    public void hello() {
        var list = List.of("hello");
        var element = list.get(1);
        log.info("{}", element);

//        throw new RuntimeException("runtimeException call");
    }
}
