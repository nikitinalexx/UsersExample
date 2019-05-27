package com.alex.nikitin.services;

import com.alex.nikitin.model.dto.MovieDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> findByNamePattern(String namePattern);

}
