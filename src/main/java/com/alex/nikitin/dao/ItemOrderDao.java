package com.alex.nikitin.dao;

import com.alex.nikitin.model.ItemOrder;
import org.springframework.data.repository.CrudRepository;

public interface ItemOrderDao extends CrudRepository<ItemOrder, Long> {

}
