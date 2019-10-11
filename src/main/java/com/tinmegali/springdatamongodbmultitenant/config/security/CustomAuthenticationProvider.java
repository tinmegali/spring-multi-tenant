package com.tinmegali.springdatamongodbmultitenant.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
 * Authenticator provider that authenticates user,
 * retuning CustomUsernamePasswordToken, a custom authentication that contain 'tenant' context information.
 *
 * @see CustomUsernamePasswordToken
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    MockUserDetailsService userDetailsService;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        // TODO hook up with real authentication system
        return runAuthentication(name, password);
    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private UsernamePasswordAuthenticationToken runAuthentication(final String username, final String password)
            throws BadCredentialsException {
        Optional<CustomUserDetails> user = Optional.ofNullable(userDetailsService.loadUserByUsername(username));
        if (user.isPresent()) {
            if (!user.get().getPassword().equals(password)) {
                throw new BadCredentialsException("Authentication failed");
            }
            // returning authentication
            return new CustomUsernamePasswordToken(user.get());
        } else {
            throw new BadCredentialsException("Authentication failed");
        }
    }
}
