package com.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "spring_security_user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;
}
