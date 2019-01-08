package com.test.springmvcjspproject.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.springmvcjspproject.model.Ticket;
import com.test.springmvcjspproject.model.User;
import com.test.springmvcjspproject.service.TicketService;
import com.test.springmvcjspproject.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private TicketService ticketService;
    @Autowired
	private UserService userService;
	private List<Ticket> tickets;
	
    @RequestMapping("/")
    public String index() {
        return "login";
    }
    
    @RequestMapping("/about")
    public String about() {
        return "about";
    }
    
    @RequestMapping("/help")
    public String help() {
        return "help";
    }
    
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;

    }
    
    @RequestMapping(value="/addTicket", method = RequestMethod.GET)
    public String addTicket(ModelMap map, @RequestParam String title, @RequestParam int priority,
    	  	@RequestParam int active, @RequestParam String description){
        User user = userService.findByEmail("aaaaa@gamail.com");
         
    	 Ticket ticket = new Ticket(); 
    	 ticket.setTitle(title);
		 ticket.setOpenedDateTime(new Date()); 
		 ticket.setPriority(priority);
		 ticket.setUser(user);
		 ticket.setActive(active);
		 ticket.setDescription(description);
		 ticketService.saveTicket(ticket);
		 
		 tickets=ticketService.getAllTickets();
		 map.addAttribute("tickets", tickets);
    	
        return"ticket";

    }
    
    @RequestMapping(value="/deleteTicket", method = RequestMethod.GET)
    public String deleteTicket(ModelMap map, @RequestParam long ticketId){
   
    	
		 ticketService.deleteTicket(ticketId);
		 
		 tickets=ticketService.getAllTickets();
		 map.addAttribute("tickets", tickets);
    	
        return"ticket";

    }
    
    @RequestMapping(value="/deleteTickets", method = RequestMethod.GET)
    public String deleteTickets(ModelMap map, @RequestParam String[] checkbox_options){
   
    	for (int i = 0; i < checkbox_options.length; i++) {		 
    		System.out.println(checkbox_options[i] + " ");
    	}
    	
		// ticketService.deleteTicket(ticketId);
		 
		 tickets=ticketService.getAllTickets();
		 map.addAttribute("tickets", tickets);
    	
        return"ticket";

    }
    
    @RequestMapping(value="/editTicket", method = RequestMethod.GET)
    public String editTicket(ModelMap map, @RequestParam long ticketId, @RequestParam String title,
    		 @RequestParam String description, @RequestParam int priority,@RequestParam int active){
   
    	Ticket ticket = ticketService.getOne(ticketId);
    	ticket.setTitle(title);
    	ticket.setDescription(description);
    	ticket.setPriority(priority);
    	ticket.setActive(active);
    	ticketService.saveTicket(ticket);
		// ticketService.deleteTicket(ticketId);
		 
		 
		 
		 tickets=ticketService.getAllTickets();
		 map.addAttribute("tickets", tickets);
    	
        return"ticket";

    }
    
   
	
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
		/*
		 * User user = new User(); user.setEmail("aaaaa@gamail.com");
		 * user.setPassword("aaaaa"); user.setName("Tome"); user.setLastName("Smith");
		 * user.setActive(1); userService.saveUser(user);
		 * 
		 * 
		 * Ticket ticket = new Ticket(); ticket.setTitle("Something new issue");
		 * ticket.setOpenedDateTime(new Date()); ticket.setPriority(4);
		 * ticket.setUser(user); ticket.setActive(1);
		 * ticket.setDescription("Something really bad");
		 * ticketService.saveTicket(ticket);
		 */
        
        tickets=ticketService.getAllTickets();
        modelAndView.addObject("tickets", tickets);
  
        modelAndView.setViewName("ticket");
        return modelAndView;
    }
    


}
