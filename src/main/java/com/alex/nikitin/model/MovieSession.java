package com.alex.nikitin.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MovieSession implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "movieSession")
    private Set<Ticket> tickets = new HashSet<>();

    @NotNull
    @ManyToOne
    private Movie movie;

    @NotNull
    @ManyToOne
    private Cinema cinema;

    @NotNull
    private LocalDateTime start;

    @NotNull
    private LocalDateTime end;

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}
