package com.alex.nikitin.dao.impl;

import com.alex.nikitin.dao.StatisticsDao;
import com.alex.nikitin.model.dto.MovieSummaryDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StatisticsDaoImpl implements StatisticsDao {
    private EntityManager entityManager;
    private static final String PROFIT_AND_VISITORS_QUERY = "select case " +
            "         when extract(hour from start) between 0 and 8 then 'night' " +
            "         when extract(hour from start) between 9 and 11 then 'morning' " +
            "         when extract(hour from start) between 12 and 17 then 'day' " +
            "         else 'evening' " +
            "         end              as time_of_day, " +
            "       sum(t.price)       as total_price, " +
            "       count(t.client_id) as total_clients " +
            "from movie_session ms, " +
            "     ticket t " +
            "where movie_id = ? " +
            "  and t.MOVIE_SESSION_ID = ms.id " +
            "  and start > ? " +
            "  and end < ? " +
            "group by time_of_day ";

    public StatisticsDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<MovieSummaryDto> calculateProfitAndVisitors(long movieId, LocalDateTime periodStart, LocalDateTime periodEnd) {
        Query query = entityManager.createNativeQuery(PROFIT_AND_VISITORS_QUERY, Tuple.class);
        query.setParameter(1, movieId);
        query.setParameter(2, periodStart);
        query.setParameter(3, periodEnd);


        List<MovieSummaryDto> summary = ((List<Tuple>) query.getResultList())
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());

        long totalIncome = summary.stream().mapToLong(MovieSummaryDto::getPriceSum).sum();
        long sumOfVisitors = summary.stream().mapToLong(MovieSummaryDto::getClientSum).sum();

        summary.add(new MovieSummaryDto("grandTotal", totalIncome, sumOfVisitors));

        return summary;
    }

    private MovieSummaryDto toDto(Tuple tuple) {
        return new MovieSummaryDto(
                tuple.get(0, String.class),
                tuple.get(1, BigInteger.class).longValue(),
                tuple.get(2, BigInteger.class).longValue()
        );
    }


}
