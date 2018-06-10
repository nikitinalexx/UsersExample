package com.alex.nikitin.dao;

import com.alex.nikitin.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
