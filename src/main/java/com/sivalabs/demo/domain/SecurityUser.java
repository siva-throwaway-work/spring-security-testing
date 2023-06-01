package com.sivalabs.demo.domain;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

public class SecurityUser extends org.springframework.security.core.userdetails.User {
    private final User user;

    public SecurityUser(User user) {
        super(
                user.getEmail(),
                user.getPassword(),
                Set.of(new SimpleGrantedAuthority(user.getRole())));
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
