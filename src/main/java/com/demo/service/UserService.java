package com.demo.service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createAdminAccount(String username, String password, String email) {
        User adminUser = new User();
        adminUser.setUsername(username);
        String encodedPassword = passwordEncoder.encode(password);
        adminUser.setPassword(encodedPassword);
        adminUser.setEmail(email);
        adminUser.setRole("ADMIN");

        userRepository.save(adminUser);
    }
}
