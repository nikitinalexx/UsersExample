package com.alex.nikitin.model.dto;

import com.alex.nikitin.model.MovieSession;

import java.util.Set;

public class CinemaDto {
    private String name;
    private String address;
    private Set<MovieSessionDto> movieSessions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<MovieSessionDto> getMovieSessions() {
        return movieSessions;
    }

    public void setMovieSessions(Set<MovieSessionDto> movieSessions) {
        this.movieSessions = movieSessions;
    }
}
