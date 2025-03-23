package com.jane.mysqlsecurityrole.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public String get(Authentication authentication) {
        return "GET::Demo controller";
    }

    @PostMapping
    public String post() {
        return "POST::Demo controller";
    }

    @PutMapping
    public String put() {
        return "PUT::Demo controller";
    }

    @DeleteMapping
    public String delete() {
        return "DELETE::Demo controller";
    }


}
