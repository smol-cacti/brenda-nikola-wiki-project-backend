package com.example.wikiProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    /**
     * @Bean public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
     * InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
     * manager.createUser(User.withUsername("user")
     * .password(bCryptPasswordEncoder.encode("userPass"))
     * .roles("USER")
     * .build());
     * manager.createUser(User.withUsername("admin")
     * .password(bCryptPasswordEncoder.encode("adminPass"))
     * .roles("USER", "ADMIN")
     * .build());
     * return manager;
     * }
     **/

    @Bean
    BCryptPasswordEncoder passwordEndcoder()
    {
        return new BCryptPasswordEncoder();
    }



}

