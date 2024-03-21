package com.clothing.service;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public interface UserService {
    boolean authenticate(String username, String password);
    void register(User user);
}

