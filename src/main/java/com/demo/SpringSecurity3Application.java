package com.demo;

import com.demo.entity.User;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurity3Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity3Application.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setEmail("h@gmail.com");
//        user.setUserName("admin");
//        user.setPassword(this.bCryptPasswordEncoder.encode("admin"));
//        user.setRole("ROLE_ADMIN");
//        this.userRepository.save(user);
//
//        User user1 = new User();
//        user1.setEmail("p@gmail.com");
//        user1.setUserName("user");
//        user1.setRole("ROLE_USER");
//        user1.setPassword(this.bCryptPasswordEncoder.encode("user"));
//
//
//        this.userRepository.save(user1);
    }
}
