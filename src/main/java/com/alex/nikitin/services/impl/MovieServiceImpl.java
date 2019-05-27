package com.alex.nikitin.services.impl;

import com.alex.nikitin.dao.MovieDao;
import com.alex.nikitin.model.Movie;
import com.alex.nikitin.model.dto.MovieDto;
import com.alex.nikitin.services.MovieService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<MovieDto> findByNamePattern(String namePattern) {
        if (StringUtils.isEmpty(namePattern)) {
            return Collections.emptyList();
        }

        return movieDao.findAll((Specification<Movie>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            String[] words = namePattern.toLowerCase().split(" ");
            for (String word : words) {
                predicates.add(builder.like(builder.lower(root.get("name")), '%' + word + '%'));
            }

            return builder.or(predicates.toArray(new Predicate[0]));
        }).stream().map(this::toDto).collect(Collectors.toList());
    }

    private MovieDto toDto(Movie movie) {
        return new MovieDto(movie.getName(), movie.getLength());
    }

}
