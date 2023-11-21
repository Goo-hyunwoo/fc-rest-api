package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello() {
        var html = "<html><body><h1>" +
                "Hello Spring boot" +
                "</h1></body></html>";

        return html;
    }
    //http://192.168.0.150:8080/api/echo/jordan/age/34/is-man/true
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(@PathVariable(name="message") String msg, @PathVariable int age, @PathVariable boolean isMan) {
        System.out.println(msg + " " + age + " " + isMan);
        // TODO 대문자로 변환해서 RETURN
        msg = msg.toUpperCase();
        return msg;
    }

    //http://192.168.0.150:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping("/book")
    public String queryParam(
            @RequestParam String category, @RequestParam String issuedYear,
            @RequestParam(name="issued-month") String issuedMonth, @RequestParam("issued_day") String issuedDay) {
        System.out.println(category + " " + issuedYear + " " + issuedMonth + " " + issuedDay);
        return "";
    }

    //http://192.168.0.150:8080/api/book2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
    @GetMapping("/book2")
    public String queryParam2(BookQueryParam bookQueryParam) {
        System.out.println(bookQueryParam);
        return "";
    }
}
