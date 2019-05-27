package com.alex.nikitin.services;

import com.alex.nikitin.model.dto.PeriodDto;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieSessionService {

    List<PeriodDto> findBreaksBetweenMovies(long cinemaId, LocalDateTime periodStart, LocalDateTime periodEnd);

}
