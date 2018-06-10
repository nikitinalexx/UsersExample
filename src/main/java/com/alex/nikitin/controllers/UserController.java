package com.alex.nikitin.controllers;

import com.alex.nikitin.model.ItemOrder;
import com.alex.nikitin.model.User;
import com.alex.nikitin.model.dto.UserDto;
import com.alex.nikitin.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> users() {
        return userService.getAllUsers().stream().map(this::userToDto).collect(Collectors.toList());
    }

    private UserDto userToDto(User user) {
        List<Long> orderIds = user.getItemOrders().stream().map(ItemOrder::getId).collect(Collectors.toList());
        return new UserDto(user.getId(), user.getName(), user.getSurname(), user.getUsername(), orderIds);
    }

}
