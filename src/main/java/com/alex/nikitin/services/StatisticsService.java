package com.alex.nikitin.services;

import com.alex.nikitin.model.dto.MovieSummaryDto;

import java.time.LocalDateTime;
import java.util.List;

public interface StatisticsService {

    List<MovieSummaryDto> calculateProfitAndVisitors(long movieId, LocalDateTime periodStart, LocalDateTime periodEnd);

}
