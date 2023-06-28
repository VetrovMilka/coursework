package com.vetrov.wallet.config;

import com.vetrov.wallet.entity.User;
import com.vetrov.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collections;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {
    @Autowired
    UserService userService;

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        User admin = userService.findUserById(1L);
        return new InMemoryUserDetailsManager(Collections.singletonList(admin));
    }
}
