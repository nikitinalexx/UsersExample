package com.alex.nikitin.dao;

import com.alex.nikitin.model.MovieSession;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MovieSessionDao extends CrudRepository<MovieSession, Long> {

    @Query("select s " +
            "from MovieSession s " +
            "where s.cinema.id = :id " +
            "and s.start >= :periodStart and s.end < :periodEnd order by s.start asc")
    List<MovieSession> findAllByIdAndPeriod(@Param("id") long id,
                                            @Param("periodStart") LocalDateTime periodStart,
                                            @Param("periodEnd") LocalDateTime periodEnd);

}
