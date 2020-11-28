package com.example.hotelproject.repository;

import java.util.List;

import com.example.hotelproject.entity.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
     List<Reservation> findByHotelId(Long hotel_id);
}