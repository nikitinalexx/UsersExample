package com.alex.nikitin.controllers;

import com.alex.nikitin.model.User;
import com.alex.nikitin.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;

@RestController("/registration")
public class UserRegistrationController {
    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json")
    public void register(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getUsername())) {
            throw new IllegalArgumentException("Username may not be empty");
        }

        if (StringUtils.isEmpty(user.getPassword()) || !user.getPassword().equals(user.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords don't match");
        }

        userService.createUser(user);
    }

}
