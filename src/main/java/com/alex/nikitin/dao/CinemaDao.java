package com.alex.nikitin.dao;

import com.alex.nikitin.model.Cinema;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CinemaDao extends CrudRepository<Cinema, Long> {

    @Query(value =
            "select c.id, c.name, c.address " +
                    "from cinema c, movie_session s " +
                    "where c.id = s.cinema_id " +
                    "and s.start >= :periodStart and s.end < :periodEnd " +
                    "group by c.id " +
                    "having count(*) >= :minAmountOfSessions", nativeQuery = true)
    List<Cinema> findAllWithMinAmountOfSessions(@Param("periodStart") LocalDateTime periodStart,
                                                @Param("periodEnd") LocalDateTime periodEnd,
                                                @Param("minAmountOfSessions") int minAmountOfSessions);

}
