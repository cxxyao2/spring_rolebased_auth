package com.jane.mysqlsecurityrole.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("management")
public class ManagementController {
    @GetMapping
    public String management() {
        return "GET:: management controller";
    }

    @PostMapping
    public String managementPost() {
        return "POST:: management controller";
    }

    @PutMapping
    public String managementPut() {
        return "PUT:: management controller";
    }

    @DeleteMapping
    public String managementDelete() {
        return "DELETE:: management controller";
    }
}
