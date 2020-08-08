package com.learn.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.learn.entities.Ticket;

@Repository
@Component
public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {

	

}
