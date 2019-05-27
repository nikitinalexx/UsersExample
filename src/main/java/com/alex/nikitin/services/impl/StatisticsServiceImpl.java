package com.alex.nikitin.services.impl;

import com.alex.nikitin.dao.StatisticsDao;
import com.alex.nikitin.model.dto.MovieSummaryDto;
import com.alex.nikitin.services.StatisticsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    private StatisticsDao statisticsDao;

    public StatisticsServiceImpl(StatisticsDao statisticsDao) {
        this.statisticsDao = statisticsDao;
    }

    @Override
    public List<MovieSummaryDto> calculateProfitAndVisitors(long movieId, LocalDateTime periodStart, LocalDateTime periodEnd) {
        return statisticsDao.calculateProfitAndVisitors(movieId, periodStart, periodEnd);
    }
}
