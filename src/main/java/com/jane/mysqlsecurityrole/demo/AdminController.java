package com.jane.mysqlsecurityrole.demo;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

    @GetMapping
    public String get(Authentication authentication) {
        System.out.println("Hello, authenticating...");
        System.out.println(authentication);
        return "GET::admin controller";
    }

    @PostMapping
    public String post() {
        return "POST::admin controller";
    }

    @PutMapping
    public String put() {
        return "PUT::admin controller";
    }

    @DeleteMapping
    public String delete() {
        return "DELETE::admin controller";
    }


}
