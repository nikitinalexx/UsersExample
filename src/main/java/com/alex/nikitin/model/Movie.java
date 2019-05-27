package com.alex.nikitin.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "movie")
    private Set<MovieSession> movieSessions = new HashSet<>();

    @ManyToMany(mappedBy = "movies")
    private Set<Cinema> cinemas = new HashSet<>();

    @NotNull
    private String name;

    @NotNull
    private int length;

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }
}
