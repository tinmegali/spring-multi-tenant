package com.tinmegali.springdatamongodbmultitenant.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class User {

    private String username;
    private String password;
    private String tenant;
    private Set<String> authorities = new HashSet<String>();


    private User() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTenant() {
        return tenant;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public static class UserBuilder {
        private String username;
        private String password;
        private String tenant;
        private Set<String> authorities;

        private UserBuilder() {
        }

        public static UserBuilder aUser() {
            return new UserBuilder();
        }

        public UserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withTenant(String tenant) {
            this.tenant = tenant;
            return this;
        }

        public UserBuilder withAuthorities(String... authorities) {
            this.authorities = new HashSet<String>();
            this.authorities.addAll(Arrays.asList(authorities));
            return this;
        }

        public User build() {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setTenant(tenant);
            user.setAuthorities(authorities);
            return user;
        }
    }
}
