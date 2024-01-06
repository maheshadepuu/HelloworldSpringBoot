package com.project.repository;

import java.util.ArrayList;


import com.project.model.Reservation;

public interface ReservationRepository 
{

	ArrayList<Reservation> getReservation();
	Reservation getReservationById(long reservationId);
	Reservation addReservation(Reservation reservation);
	Reservation updateReservation(long reservationId, Reservation reservation);
	void deleteReservation (long reservationId);
}
