package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Reservation;

public interface ReservationJpaRepository extends JpaRepository<Reservation,Long>
{

}
