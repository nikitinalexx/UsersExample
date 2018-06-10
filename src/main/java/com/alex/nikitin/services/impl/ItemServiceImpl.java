package com.alex.nikitin.services.impl;

import com.alex.nikitin.dao.ItemDao;
import com.alex.nikitin.model.Item;
import com.alex.nikitin.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    private final ItemDao itemDao;

    @Autowired
    public ItemServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public List<Item> getAllItems() {
        Iterable<Item> iterable = itemDao.findAll();
        List<Item> items = new ArrayList<>();
        iterable.forEach(items::add);
        return items;
    }

    @Override
    public Item createItem(Item item) {
        try {
            return itemDao.save(item);
        } catch (Exception e) {
            throw new IllegalArgumentException("Such user or such order don't exist");
        }
    }
}
