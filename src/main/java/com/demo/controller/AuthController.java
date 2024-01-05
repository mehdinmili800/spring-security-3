package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;




    @PostMapping("/create-admin")
    public ResponseEntity<String> createAdmin(@RequestBody User adminRequest) {
        userService.createAdminAccount(adminRequest.getUsername(), adminRequest.getPassword(), adminRequest.getEmail());
        return ResponseEntity.ok("Admin account created successfully");
    }
    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody User userRequest){
        userService.createUserAccount(userRequest.getUsername(),userRequest.getPassword(),userRequest.getEmail());
        return ResponseEntity.ok("User account created successfully");
    }
}
