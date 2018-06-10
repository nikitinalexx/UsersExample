package com.alex.nikitin.controllers;

import com.alex.nikitin.model.Item;
import com.alex.nikitin.model.ItemOrder;
import com.alex.nikitin.model.User;
import com.alex.nikitin.model.dto.ItemDto;
import com.alex.nikitin.services.ItemOrderService;
import com.alex.nikitin.services.ItemService;
import com.alex.nikitin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ItemController {
    private final ItemService itemService;
    private final UserService userService;
    private final ItemOrderService itemOrderService;

    @Autowired
    public ItemController(ItemService itemService, UserService userService, ItemOrderService itemOrderService) {
        this.itemService = itemService;
        this.userService = userService;
        this.itemOrderService = itemOrderService;
    }

    @PostMapping(value = "/user/{userId}/order/{orderId}/items/new", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void createItem(@PathVariable long userId, @PathVariable long orderId, @RequestBody Item item) {
        if (StringUtils.isEmpty(item.getName()) || item.getPrice() == null) {
            throw new IllegalArgumentException("Item should contain name and price");
        }
        Optional<User> userById = userService.getUserById(userId);
        if (!userById.isPresent()) {
            throw new IllegalArgumentException("Such user doesn't exist");
        }
        Optional<ItemOrder> itemOrderById = itemOrderService.getItemOrderById(orderId);
        if (!itemOrderById.isPresent()) {
            throw new IllegalArgumentException("Such order doesn't exist");
        }
        if (userById.get().getId() != itemOrderById.get().getCustomer().getId()) {//safe == because the same persistence context
            throw new IllegalArgumentException("Such user doesn't have such order");
        }
        item.setItemOrder(itemOrderById.get());
        itemService.createItem(item);
    }

    @GetMapping("/items")
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems().stream().map(this::itemToDto).collect(Collectors.toList());
    }

    private ItemDto itemToDto(Item item) {
        return new ItemDto(item.getId(), item.getItemOrder().getId(), item.getName(), item.getPrice());
    }

}
