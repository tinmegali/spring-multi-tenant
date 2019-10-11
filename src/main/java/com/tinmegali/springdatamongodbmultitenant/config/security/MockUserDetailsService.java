package com.tinmegali.springdatamongodbmultitenant.config.security;

import com.tinmegali.springdatamongodbmultitenant.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

/**
 * Custom UserDetailsService that provide some mock users.
 */
@Component
public class MockUserDetailsService implements UserDetailsService {

    private User[] users = {
            User.UserBuilder.aUser()
                    .withUsername("admin1")
                    .withPassword("password")
                    .withAuthorities("ADMIN")
                    .build(),
            User.UserBuilder.aUser()
                    .withUsername("admin2")
                    .withPassword("password")
                    .withAuthorities("ADMIN")
                    .build(),
            User.UserBuilder.aUser()
                    .withUsername("user")
                    .withPassword("password")
                    .withAuthorities("USER")
                    .withTenant("tenant1")
                    .build(),
            User.UserBuilder.aUser()
                    .withUsername("user1")
                    .withPassword("password")
                    .withAuthorities("USER")
                    .withTenant("tenant1")
                    .build(),
            User.UserBuilder.aUser()
                    .withUsername("user2")
                    .withPassword("password")
                    .withAuthorities("USER")
                    .withTenant("tenant2")
                    .build(),
    };

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Arrays.stream(users)
                .filter(u ->
                        u.getUsername().equals(username))
                .findFirst();
        // returning authentication
        return user.map(CustomUserDetails::new)
                .orElse(null);
    }
}
