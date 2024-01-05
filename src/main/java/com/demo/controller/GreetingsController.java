package com.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/greetings")
@PreAuthorize("hasRole('ADMIN')")

public class GreetingsController {


    @GetMapping("/hello")
    @PreAuthorize("hasAnyAuthority('admin:read')")
    public ResponseEntity<String> greetings() {
        return ResponseEntity.ok("public hello");
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/admin")
//    public ResponseEntity<String> adminGreetings() {
//        return ResponseEntity.ok("hello from admin");
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/user")
//    public ResponseEntity<String> normalGreetings() {
//        return ResponseEntity.ok("bye from normal");
//    }


}
