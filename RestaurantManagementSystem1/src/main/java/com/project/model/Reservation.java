package com.project.model;
import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.enums.ReservationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
 @Data
@Entity
@Table(name="reservation")
public class Reservation 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
	
	private String tableType;
	
	private String description;
	
	private Date dateTime;
	
	private ReservationStatus reservationStatus;
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="user_id",nullable=false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JsonIgnore
	private User user;
	private long customerId;
	
}

