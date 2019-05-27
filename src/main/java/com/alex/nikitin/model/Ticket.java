package com.alex.nikitin.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Ticket implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private MovieSession movieSession;

    @NotNull
    private int price;

    @NotNull
    private int clientId;

}
