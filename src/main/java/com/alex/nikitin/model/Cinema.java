package com.alex.nikitin.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cinema implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "cinema_movie",
            joinColumns = {@JoinColumn(name = "cinema_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Movie> movies = new HashSet<>();

    @OneToMany(mappedBy = "cinema")
    private Set<MovieSession> movieSessions = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
