package com.alex.nikitin.dao;

import com.alex.nikitin.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketDao extends CrudRepository<Ticket, Long> {

}
