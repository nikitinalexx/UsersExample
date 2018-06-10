package com.alex.nikitin.dao;

import com.alex.nikitin.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDao extends CrudRepository<Item, Long> {

}
