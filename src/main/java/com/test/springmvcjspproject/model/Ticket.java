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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;


import lombok.Data;


@Data
@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	private long ticketId;
	
	@Column(name = "title")
	@NotEmpty(message = "*Please provide a title")
	private String title;
	
	@Column(name = "openedDateTime")
	private Date openedDateTime;
	
	@Column(name = "priority")
	private Integer priority;
	
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_user")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	@Column(name = "active")
	private int active;
	
	@Column(name = "description")
	@NotEmpty(message = "*Please enter the description")
	private String description;

	public Ticket(@NotEmpty(message = "*Please provide a title") String title, Date openedDateTime,
			@NotEmpty(message = "*Please enter an integer") Integer priority, User user, int active,
			@NotEmpty(message = "*Please enter the description") String description) {
		super();
		this.title = title;
		this.openedDateTime = openedDateTime;
		this.priority = priority;
		this.user = user;
		this.active = active;
		this.description = description;
	}
	public Ticket() {}
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getOpenedDateTime() {
		return openedDateTime;
	}
	public void setOpenedDateTime(Date openedDateTime) {
		this.openedDateTime = openedDateTime;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}