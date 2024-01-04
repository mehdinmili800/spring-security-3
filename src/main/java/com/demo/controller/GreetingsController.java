package com.demo.controller;

import com.demo.service.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/greetings")

public class GreetingsController {


    @GetMapping("/hello")
    public ResponseEntity<String> greetings() {
        return ResponseEntity.ok("public hello");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> adminGreetings() {
        return ResponseEntity.ok("hello from admin");
    }

    @PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/normal")
    public ResponseEntity<String> normalGreetings() {
        return ResponseEntity.ok("bye from normal");
    }


}
