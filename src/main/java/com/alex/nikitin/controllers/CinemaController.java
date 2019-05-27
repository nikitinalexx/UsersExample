package com.alex.nikitin.controllers;

import com.alex.nikitin.model.dto.CinemaDto;
import com.alex.nikitin.model.dto.PeriodDto;
import com.alex.nikitin.services.CinemaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CinemaController {
    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/cinemas")
    public ResponseEntity<List<CinemaDto>> cinemas(@RequestParam(name = "periodStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodStart,
                                                   @RequestParam(name = "periodEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodEnd) {
        List<CinemaDto> allCinemas = cinemaService.findAllWithMinAmountOfSessions(periodStart, periodEnd);
        return ResponseEntity.ok(allCinemas);
    }

}
