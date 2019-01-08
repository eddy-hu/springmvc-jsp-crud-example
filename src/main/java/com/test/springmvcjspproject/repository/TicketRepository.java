package com.test.springmvcjspproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.springmvcjspproject.model.Ticket;
import com.test.springmvcjspproject.model.User;



@Repository("ticketRepository")
public interface TicketRepository extends JpaRepository<Ticket, Long> {
   // User findById(String email);
}