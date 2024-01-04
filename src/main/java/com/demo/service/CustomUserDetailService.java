package com.demo.service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("no user found");
        }
        return new CustomUserDetail(user);

    }

//    public void createAdminAccount() {
//        User adminUser = new User();
//        adminUser.setUserName("admin");
//        String encodedPassword = passwordEncoder.encode("adminPassword");
//        adminUser.setPassword(encodedPassword);
//        adminUser.setEmail("admin@example.com");
//        adminUser.setRole("ROLE_ADMIN");
//
//        userRepository.save(adminUser);
//    }
}
