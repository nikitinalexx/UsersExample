package com.alex.nikitin.services.impl;

import com.alex.nikitin.dao.MovieSessionDao;
import com.alex.nikitin.model.MovieSession;
import com.alex.nikitin.model.dto.PeriodDto;
import com.alex.nikitin.services.MovieSessionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private static final long FIFTEEN_MINUTES = 15;
    private final MovieSessionDao movieSessionDao;

    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public List<PeriodDto> findBreaksBetweenMovies(long cinemaId, LocalDateTime periodStart, LocalDateTime periodEnd) {
        List<MovieSession> movieSessions = movieSessionDao.findAllByIdAndPeriod(cinemaId, periodStart, periodEnd);

        List<PeriodDto> result = new ArrayList<>();
        MovieSession previous = null;
        for (MovieSession current : movieSessions) {
            if (previous != null) {
                long minutesDifference = ChronoUnit.MINUTES.between(previous.getEnd(), current.getStart());
                if (minutesDifference > FIFTEEN_MINUTES) {
                    result.add(new PeriodDto(previous.getEnd().toString(), current.getStart().toString()));
                }
            }
            previous = current;
        }
        return result;
    }

}
