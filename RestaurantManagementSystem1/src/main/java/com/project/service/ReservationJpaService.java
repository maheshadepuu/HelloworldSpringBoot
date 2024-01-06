package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.project.model.User;

import com.project.model.Reservation;
import com.project.repository.ReservationJpaRepository;
import com.project.repository.ReservationRepository;
import com.project.repository.UserJpaRepository;

@Service
public class ReservationJpaService implements ReservationRepository
{
	@Autowired
	public ReservationJpaRepository reservationJpaRepository;
	@Autowired
    public UserJpaRepository userJpaRepository;
	@Override
	public ArrayList<Reservation> getReservation() {
		List<Reservation> reservationList=reservationJpaRepository.findAll();
		ArrayList<Reservation> reservations=new ArrayList<>(reservationList);
		return reservations;
	}
	@Override
	public Reservation getReservationById(long reservationId) {
		try
		{
		Reservation	 reservation= reservationJpaRepository.findById(reservationId).get();
		return reservation;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public Reservation addReservation(Reservation reservation) {
		User user=reservation.getUser(); 
		 
		 long UserId=reservation.getId(); 
		 try 
		 {
			 User user1=userJpaRepository.findById(UserId).get();
		     reservation.setUser(user1);
		    reservationJpaRepository.save(reservation);
		     return reservation;
		 }
		 catch(Exception e)
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
	}
	@Override
	public Reservation updateReservation(long reservationId, Reservation reservation) {
		try
		{
		Reservation existingreservation= reservationJpaRepository.findById(reservationId).get();
		if(reservation.getTableType()!=null)
		{
			existingreservation.setTableType(reservation.getTableType());
		}
		
		if(reservation.getDescription()!=null)
		{
			existingreservation.setDescription(reservation.getDescription());
		}
		if(reservation.getDateTime()!=null)
		{
			existingreservation.setDateTime(reservation.getDateTime());
		}
		if(reservation.getUser()!=null)
		{
			User user=reservation.getUser(); 
			long userId=user.getId(); 
			User newUser=userJpaRepository.findById(userId).get();
			existingreservation.setUser(newUser);
		}
		reservationJpaRepository.save(existingreservation);


		return existingreservation;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public void deleteReservation(long reservationId) {
		try 
		{
		Reservation reservation= reservationJpaRepository.findById(reservationId).get();
		if(reservation!=null)
		{
			reservationJpaRepository.deleteById(reservationId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
