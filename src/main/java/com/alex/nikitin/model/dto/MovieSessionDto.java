package com.alex.nikitin.model.dto;

import com.alex.nikitin.model.Ticket;

import java.time.LocalDateTime;
import java.util.Set;

public class MovieSessionDto {
    private Set<TicketDto> tickets;
    private LocalDateTime start;
    private LocalDateTime end;

    public Set<TicketDto> getTickets() {
        return tickets;
    }

    public void setTickets(Set<TicketDto> tickets) {
        this.tickets = tickets;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
