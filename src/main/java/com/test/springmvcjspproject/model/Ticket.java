package com.test.springmvcjspproject.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


import lombok.Data;


@Data
@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	private int ticketId;
	
	@Column(name = "tittle")
	@NotEmpty(message = "*Please provide a tittle")
	private String tittle;
	
	@Column(name = "openedDateTime")
	private Date openedDateTime;
	
	@Column(name = "priority")
	@NotEmpty(message = "*Please enter an integer")
	private Integer priority;
	
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;
	
	@Column(name = "active")
	private int active;
	
	@Column(name = "description")
	@NotEmpty(message = "*Please enter the description")
	private String description;

}