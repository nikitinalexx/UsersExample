package com.alex.nikitin.controllers;

import com.alex.nikitin.model.dto.MovieSummaryDto;
import com.alex.nikitin.services.StatisticsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/profitAndVisitors")
    public ResponseEntity<List<MovieSummaryDto>> cinemas(@RequestParam(name = "movieId") long movieId,
                                                         @RequestParam(name = "periodStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodStart,
                                                         @RequestParam(name = "periodEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodEnd) {
        return ResponseEntity.ok(statisticsService.calculateProfitAndVisitors(movieId, periodStart, periodEnd));
    }

}
