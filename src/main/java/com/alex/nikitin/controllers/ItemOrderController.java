package com.alex.nikitin.controllers;

import com.alex.nikitin.model.Item;
import com.alex.nikitin.model.ItemOrder;
import com.alex.nikitin.model.User;
import com.alex.nikitin.model.dto.ItemOrderDto;
import com.alex.nikitin.services.ItemOrderService;
import com.alex.nikitin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ItemOrderController {
    private final ItemOrderService itemOrderService;
    private final UserService userService;

    @Autowired
    public ItemOrderController(ItemOrderService itemOrderService, UserService userService) {
        this.itemOrderService = itemOrderService;
        this.userService = userService;
    }

    @PostMapping(value = "/user/{userId}/orders/new", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void createItem(@PathVariable long userId, @RequestBody ItemOrder itemOrder) {
        if (StringUtils.isEmpty(itemOrder.getName()) || StringUtils.isEmpty(itemOrder.getDescription())) {
            throw new IllegalArgumentException("Order should contain both name and description");
        }
        Optional<User> userById = userService.getUserById(userId);
        if (!userById.isPresent()) {
            throw new IllegalArgumentException("Such user doesn't exist");
        } else {
            itemOrder.setCustomer(userById.get());
        }
        itemOrderService.createItemOrder(itemOrder);
    }

    @GetMapping("/orders")
    public List<ItemOrderDto> getAllItemOrders() {
        return itemOrderService.getAllItemOrders().stream().map(this::itemOrderToDto).collect(Collectors.toList());
    }

    private ItemOrderDto itemOrderToDto(ItemOrder itemOrder) {
        List<Long> itemIds = itemOrder.getItems().stream().map(Item::getId).collect(Collectors.toList());
        return new ItemOrderDto(itemOrder.getId(), itemOrder.getCustomer().getId(), itemOrder.getName(), itemOrder.getDescription(), itemIds);
    }


}
