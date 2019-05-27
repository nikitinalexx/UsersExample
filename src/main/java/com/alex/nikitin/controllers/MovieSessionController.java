package com.alex.nikitin.controllers;

import com.alex.nikitin.model.dto.PeriodDto;
import com.alex.nikitin.services.MovieSessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class MovieSessionController {
    private final MovieSessionService movieSessionService;

    public MovieSessionController(MovieSessionService movieSessionService) {
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/breaks")
    public ResponseEntity<List<PeriodDto>> cinemas(@RequestParam(name = "id") long id,
                                                   @RequestParam(name = "periodStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodStart,
                                                   @RequestParam(name = "periodEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodEnd) {
        List<PeriodDto> breakBetweenPeriods = movieSessionService.findBreaksBetweenMovies(id, periodStart, periodEnd);
        return ResponseEntity.ok(breakBetweenPeriods);
    }

}
