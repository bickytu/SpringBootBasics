package com.learn.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entities.Ticket;
import com.learn.service.TicketBookingService;

@RestController
@RequestMapping("/api")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	@GetMapping("/ticket/{ticketId}")
	public Optional<Ticket> getTicket(@PathVariable("ticketId") Integer ticketId) { return
	  ticketBookingService.getTicket(ticketId); 
	}
	
	@GetMapping("/alltickets")
	public Iterable<Ticket> getAllTicket(){
		return ticketBookingService.getAllTicket();
	}

	@PostMapping("/createtickets")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketBookingService.createTicket(ticket);
	}
		
	@DeleteMapping("/delete/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Integer tickedId) {
		ticketBookingService.delete(tickedId);
		System.out.println("DELETED RECORD");
	}
	
	@PutMapping("/updateticket/{ticketId}/{ticketType}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId, @PathVariable("ticketType") String ticketType) {
		return ticketBookingService.updateTicket(ticketId, ticketType);
	}
	
}
