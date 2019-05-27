package com.alex.nikitin.dao;

import com.alex.nikitin.model.dto.MovieSummaryDto;

import java.time.LocalDateTime;
import java.util.List;

public interface StatisticsDao {

    List<MovieSummaryDto> calculateProfitAndVisitors(long movieId, LocalDateTime periodStart, LocalDateTime periodEnd);
}
