package com.parwaz.training.service;

import com.parwaz.training.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User saveUser(User user);
}
