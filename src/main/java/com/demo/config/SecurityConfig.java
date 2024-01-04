package com.demo.config;

import com.demo.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public DaoAuthenticationProvider daoAuthenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.customUserDetailService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;

    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails normalUser = User.withUsername("harshil")
//                .password(passwordEncoder().encode("password"))
//                .roles("NORMAL")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(normalUser, admin);
//        return userDetailsManager;
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests()

                // if you comment these lines below then use preAuthorize @PreAuthorize("hasRole")
//                .requestMatchers("api/v1/greetings/admin")
//                .hasRole("ROLE_ADMIN")
//                .requestMatchers("api/v1/greetings/hello")
//                .permitAll()
                .requestMatchers("/admin/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        http.authenticationProvider(daoAuthenticationProvider());
        return http.build();
    }
}
