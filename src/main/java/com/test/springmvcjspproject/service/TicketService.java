package com.test.springmvcjspproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springmvcjspproject.model.Ticket;
import com.test.springmvcjspproject.repository.TicketRepository;



@Service("ticketService")
public class TicketService {
	
	private TicketRepository ticketRepository;
	
    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
   
    }
    
    public void saveTicket(Ticket ticket) {
    	ticketRepository.save(ticket);
    }
    
    public void deleteTicket(long id) {
    	ticketRepository.deleteById(id);
    }
    
    public List<Ticket> getAllTickets() {
    	return ticketRepository.findAll();
    	
    }
    
    
}
