package com.alex.nikitin.services;

import com.alex.nikitin.model.ItemOrder;
import com.alex.nikitin.model.User;

import java.util.List;
import java.util.Optional;

public interface ItemOrderService {

    List<ItemOrder> getAllItemOrders();

    ItemOrder createItemOrder(ItemOrder itemOrder);

    Optional<ItemOrder> getItemOrderById(long id);
}
