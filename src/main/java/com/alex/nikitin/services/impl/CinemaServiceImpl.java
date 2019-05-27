package com.alex.nikitin.services.impl;

import com.alex.nikitin.dao.CinemaDao;
import com.alex.nikitin.model.Cinema;
import com.alex.nikitin.model.dto.CinemaDto;
import com.alex.nikitin.services.CinemaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService {
    private static final int MIN_AMOUNT_OF_SESSIONS_PER_CINEMA = 6;
    private final CinemaDao cinemaDao;

    public CinemaServiceImpl(CinemaDao cinemaDao) {
        this.cinemaDao = cinemaDao;
    }

    @Override
    public List<CinemaDto> findAllWithMinAmountOfSessions(LocalDateTime periodStart, LocalDateTime periodEnd) {
        List<Cinema> allWithMinAmountOfSessions = cinemaDao.findAllWithMinAmountOfSessions(periodStart, periodEnd, MIN_AMOUNT_OF_SESSIONS_PER_CINEMA);
        return allWithMinAmountOfSessions.stream().map(this::toDto).collect(Collectors.toList());
    }

    private CinemaDto toDto(Cinema cinema) {
        CinemaDto cinemaDto = new CinemaDto();
        cinemaDto.setName(cinema.getName());
        cinemaDto.setAddress(cinema.getAddress());
        return cinemaDto;
    }

}
