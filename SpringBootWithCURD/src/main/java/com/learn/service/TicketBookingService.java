package com.learn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.learn.dao.TicketBookingDao;
import com.learn.entities.Ticket;

@Service
@Component
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}

	public Optional<Ticket> getTicket(Integer ticketId) {
		return ticketBookingDao.findById(ticketId);
		
	}

	public void delete(Integer tickedId) {
		ticketBookingDao.deleteById(tickedId);
	}

	public Iterable<Ticket> getAllTicket() {
		return ticketBookingDao.findAll();
	}
	
	public Ticket updateTicket(Integer ticketId, String ticketType) {
		Optional<Ticket> ticket = ticketBookingDao.findById(ticketId);
		Ticket t= ticket.get();
		t.setTicketType(ticketType);
		ticketBookingDao.save(t);
		return t;
	}

}
