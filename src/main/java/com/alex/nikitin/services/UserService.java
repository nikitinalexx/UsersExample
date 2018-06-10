package com.alex.nikitin.services;

import com.alex.nikitin.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    User createUser(User user);

    Optional<User> getUserById(long id);
}
