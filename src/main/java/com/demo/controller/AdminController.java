package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.CustomUserDetailService;
import com.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;



    @PostMapping("/create")
    public ResponseEntity<String> createAdmin(@RequestBody User adminRequest) {
        userService.createAdminAccount(adminRequest.getUsername(), adminRequest.getPassword(), adminRequest.getEmail());
        return ResponseEntity.ok("Admin account created successfully");
    }
}
