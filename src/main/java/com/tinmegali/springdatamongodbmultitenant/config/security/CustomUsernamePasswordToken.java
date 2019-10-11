package com.tinmegali.springdatamongodbmultitenant.config.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Custom username and password token authentication.
 * Adds property 'tenant' to authenticated users
 *
 * @see CustomUserDetails
 */
public class CustomUsernamePasswordToken extends UsernamePasswordAuthenticationToken {

    private CustomUserDetails userDetails;

    public  CustomUsernamePasswordToken(CustomUserDetails userDetails) {
        super(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        this.userDetails = userDetails;
    }

    public String getTenant() {
        return userDetails.getTenant();
    }
}
