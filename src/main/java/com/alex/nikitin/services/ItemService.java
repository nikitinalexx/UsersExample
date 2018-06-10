package com.alex.nikitin.services;

import com.alex.nikitin.model.Item;
import com.alex.nikitin.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    Item createItem(Item item);
}
