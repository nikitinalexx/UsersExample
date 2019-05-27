package com.alex.nikitin.services;

import com.alex.nikitin.model.dto.CinemaDto;

import java.time.LocalDateTime;
import java.util.List;

public interface CinemaService {

    List<CinemaDto> findAllWithMinAmountOfSessions(LocalDateTime periodStart, LocalDateTime periodEnd);

}
