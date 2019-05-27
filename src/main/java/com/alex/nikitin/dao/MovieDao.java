package com.alex.nikitin.dao;

import com.alex.nikitin.model.Movie;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MovieDao extends CrudRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {

}
