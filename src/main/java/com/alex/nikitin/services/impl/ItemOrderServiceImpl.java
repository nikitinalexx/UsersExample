package com.alex.nikitin.services.impl;

import com.alex.nikitin.dao.ItemOrderDao;
import com.alex.nikitin.model.ItemOrder;
import com.alex.nikitin.model.User;
import com.alex.nikitin.services.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemOrderServiceImpl implements ItemOrderService {
    private final ItemOrderDao itemOrderDao;

    @Autowired
    public ItemOrderServiceImpl(ItemOrderDao itemOrderDao) {
        this.itemOrderDao = itemOrderDao;
    }

    @Override
    public List<ItemOrder> getAllItemOrders() {
        Iterable<ItemOrder> iterable = itemOrderDao.findAll();
        List<ItemOrder> itemOrders = new ArrayList<>();
        iterable.forEach(itemOrders::add);
        return itemOrders;
    }

    @Override
    public ItemOrder createItemOrder(ItemOrder itemOrder) {
        try {
            return itemOrderDao.save(itemOrder);
        } catch(Exception e) {
            throw new RuntimeException("Such user doesn't exist", e.getCause());
        }
    }

    @Override
    public Optional<ItemOrder> getItemOrderById(long id) {
        return itemOrderDao.findById(id);
    }

}
