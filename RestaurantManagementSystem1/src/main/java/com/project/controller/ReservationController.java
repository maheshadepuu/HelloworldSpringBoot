package com.project.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Product;
import com.project.model.Reservation;
import com.project.service.ProductJpaService;
import com.project.service.ReservationJpaService;

@RestController
public class ReservationController
{
	@Autowired
	private ReservationJpaService  reservationService;

    @GetMapping("/reservations")
    public ArrayList<Reservation> getReservation()
	{
	  return reservationService.getReservation();
	}
    @GetMapping("reservations/{reservationId}")
    public Reservation getReservationById(@PathVariable("reservationId") long reservationId) 
	{
		return reservationService.getReservationById(reservationId);
	}
   
    @PostMapping("/user/reservations/addnewreservation")
    public Reservation addReservation(@RequestBody Reservation reservation)
	{
		return reservationService.addReservation(reservation);
	}
    
    @PutMapping("reservations/{reservationId}")
    public Reservation updateReservation(@PathVariable("reservationId") long reservationId, @RequestBody Reservation reservation) 
    {
		return reservationService.updateReservation(reservationId, reservation);
    }
    
    @DeleteMapping("reservations/{reservationId}")
    public void deleteReservation(@PathVariable("reservationId") long reservationId)
    {
    	reservationService.deleteReservation(reservationId);
    }
}

